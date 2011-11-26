package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class AutoCallDistributors extends Controller {

    public static void index() {
    	List routes = AcdRoute.find("order by route_id desc").fetch();
        render("AutoCallDistributors/route.html", routes);
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
                Logger.warn(error.message());
            }
        } else {
            // Write data into database.
            if (condition_id != null) {
                AcdCondition obj = AcdCondition.findById(condition_id);
                obj.edit("obj", params.all());
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
        Logger.debug("Look -> edit_id -> " + edit_id);
        AcdCondition cond = AcdCondition.findById(edit_id);
        // Dispatch data as JSON
        renderJSON(cond);
    }

    public static void deleteCond(@Required(message="No found ID to delete data.") Integer delete_id) {
        Logger.debug("Look -> delete_id -> " + delete_id);
        // Find entity for delete.
        AcdCondition cond = AcdCondition.findById(delete_id);
        cond.delete();
        flash.success("The data been deleted.");
        // Dispatch to web page.
        condition();
    }

}