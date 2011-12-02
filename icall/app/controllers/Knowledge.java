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
		List<KnwStatus> statusList = KnwStatus.find("order by status_id asc").fetch();
		if (statusList.size() > 0) {
			flash.success("Found "+statusList.size()+" result(s).");
		}
		render("knowledge/status.html", statusList);
	}
	
	/**
	* prepare status for save/update
	* @param status_id
	**/
	public static void prepareStatus(Integer status_id) {
		if (status_id != null) {
			KnwStatus knwStatus = KnwStatus.findById(status_id);
        	renderJSON(knwStatus);
		}
	}
	
	/**
	* Save and update knwStatus
	* @param status_id
	* @param status_name
	* @param status_description
	**/
	public static void saveStatus(Integer status_id, String status_name, String status_description) {
		validation.required("Name", status_name);
		
		if (!validation.hasErrors()) {
			if (status_id == null) {
				KnwStatus knwStatus = new KnwStatus(null, null);
				knwStatus.status_name = status_name;
				knwStatus.status_description = status_description;
				knwStatus.save();
				flash.success("The data been created.");
			} else {
				KnwStatus knwStatus = KnwStatus.findById(status_id);
				knwStatus.status_name = status_name;
				knwStatus.status_description = status_description;
				knwStatus.status_update_date = new Date();
				knwStatus.save();
				flash.success("The data been updated.");
			}
		}
		
		List<KnwStatus> statusList = KnwStatus.find("order by status_id asc").fetch();
		render("knowledge/status.html", statusList);
	}
    
    /**
    * delete status
    * @param delete_id
    **/
    public static void deleteStatus(@Required(message="No found ID to delete data.") Integer delete_id) {
        KnwStatus knwStatus = KnwStatus.findById(delete_id);
        knwStatus.delete();
        flash.success("The data been deleted.");
        
        List<KnwStatus> statusList = KnwStatus.find("order by status_id asc").fetch();
		render("knowledge/status.html", statusList);
    }
	
}