package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class AutoCallDistributors extends Controller {

    public static void index() {
		List conditions = AcdCondition.find("order by condition_id desc").fetch();
    	List routes = AcdRoute.find("order by route_id desc").fetch();
        render("AutoCallDistributors/route.html", conditions, routes);
    }

    public static void condition() {
    	List conditions = AcdCondition.find("order by condition_id desc").fetch();
    	render("AutoCallDistributors/condition.html", conditions);
    }

    public static void route() {
    	index();
    }

    public static void saveCond(Integer condition_id) {
        // Logging
        Logger.debug("Look -> condition_id -> " + condition_id);
        Logger.debug("Look -> condition_name -> " + params.get("condition_name"));
        Logger.debug("Look -> condition_description -> " + params.get("condition_description"));
        // Data validation
        validation.required(params.get("condition_name"));
        // Is validation error valid?
        if (validation.hasErrors()) {
            // Required data is invalid
            for(play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
                Logger.warn(error.message());
            }
        } else {
            // Write data into database.
            if (condition_id != null) {
                AcdCondition obj = AcdCondition.findById(condition_id);
                obj.condition_name = params.get("condition_name");
                obj.condition_description = params.get("condition_description");
                obj.condition_update_date = new Date();
                obj.save();
                flash.success("The data been updated.");
            } else {
                AcdCondition obj = new AcdCondition(null,null,null);
                obj.condition_name = params.get("condition_name");
                obj.condition_description = params.get("condition_description");
                obj.condition_update_date = new Date();
                obj.save();
                flash.success("The data been created.");
            }    
        }
        // Dispatch to web page.
        condition();
    }

    public static void editCond(@Required(message="No found ID to edit data.") Integer edit_id) {
        Logger.debug("Edit -> condition_id -> " + edit_id);
        AcdCondition cond = AcdCondition.findById(edit_id);
        // Dispatch data as JSON
        renderJSON(cond);
    }

    public static void deleteCond(@Required(message="No found ID to delete data.") Integer delete_id) {
        Logger.debug("Delete -> condition_id -> " + delete_id);
        // Find entity for delete.
        AcdCondition cond = AcdCondition.findById(delete_id);
        cond.delete();
        flash.success("The data been deleted.");
        // Dispatch to web page.
        condition();
    }

	public static void saveRoute(Integer route_id, @Required(message="No found condition selected.") Integer acd_condition_id) {
        // Logging
        Logger.debug("Look -> route_id -> " + route_id);
        Logger.debug("Look -> route_name -> " + params.get("route_name"));
        Logger.debug("Look -> route_description -> " + params.get("route_description"));
		Logger.debug("Look -> route_caller -> " + params.get("route_caller"));
        Logger.debug("Look -> route_called -> " + params.get("route_called"));
		Logger.debug("Look -> condition_id -> " + acd_condition_id);
        // Data validation
        validation.required(params.get("route_name"));
		validation.required(acd_condition_id);
        // Is validation error valid?
        if (validation.hasErrors()) {
            // Required data is invalid
            for(play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
                Logger.warn(error.message());
            }
        } else {
			AcdCondition acdCondition = AcdCondition.findById(acd_condition_id);
            // Write data into database.
            if (route_id != null) {
                AcdRoute obj = AcdRoute.findById(route_id);
                obj.route_name = params.get("route_name");
                obj.route_description = params.get("route_description");
				obj.route_caller = params.get("route_caller");
				obj.route_caller = params.get("route_caller");
                obj.route_update_date = new Date();
				obj.acd_condition_id = acdCondition;
                obj.save();
                flash.success("The data been updated.");
            } else {
                AcdRoute obj = new AcdRoute(null,null,null,null,null);
                obj.route_name = params.get("route_name");
                obj.route_description = params.get("route_description");
				obj.route_caller = params.get("route_caller");
				obj.route_called = params.get("route_called");
                obj.route_create_date = new Date();
				obj.acd_condition_id = acdCondition;
                obj.save();
                flash.success("The data been created.");
            }    
        }
        // Dispatch to web page.
        index();
    }

    public static void editRoute(@Required(message="No found ID to edit data.") Integer edit_id) {
        Logger.debug("Edit -> route_id -> " + edit_id);
        AcdRoute route = AcdRoute.findById(edit_id);
        // Dispatch data as JSON
        renderJSON(route);
    }

    public static void deleteRoute(@Required(message="No found ID to delete data.") Integer delete_id) {
        Logger.debug("Delete -> route_id -> " + delete_id);
        // Find entity for delete.
        AcdRoute route = AcdRoute.findById(delete_id);
        route.delete();
        flash.success("The data been deleted.");
        // Dispatch to web page.
        index();
    }
}