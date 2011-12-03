/* 
 * ACD Condition
 * - JavaScript functions
 * @html /views/AutoCallDistributors/condition.html
 *
 * @author Sarayut Utsakoo
 *
 */
var ria = {
	condEdit : function(cond_id) {
		$.post(editCond({edit_id: cond_id}), function(cond){
			if (cond) {
				$('#condition_id').val(cond.condition_id);
				$('#condition_name').val(cond.condition_name);
				$('#condition_description').val(cond.condition_description);
				$('#conditionForm').append("<div class='clearfix condition_update_date'></div>");
				$('.condition_update_date').append("<label for='condition_description'>Last updated</label></div>");
				$('.condition_update_date').append("<div class='input'>" + cond.condition_update_date + "</div></div>");
									        
				// Popup modal panel
				$('#modal-from-dom').modal('toggle');
			} else {
				alert("Nothing is returned.");
			}
		});
	},
	condDelete : function(cond_id) {
		$('#delete_id').val(cond_id);
		$('#modal-from-delete').modal('toggle')
	},	
	routeEdit : function(route_id) {
		$.post(editRoute({edit_id: route_id}), function(route){
			if (route) {
				$('#route_id').val(route.route_id);
				$('#route_name').val(route.route_name);
				$('#route_description').val(route.route_description);
				$('#route_caller').val(route.route_caller);
				$('#route_called').val(route.route_called);
				$('#acd_condition_id').val(route.acd_condition_id.condition_id);
				
				$('#routeForm').append("<div class='clearfix route_create_date'></div>");
				$('.route_create_date').append("<label for='route_create_date'>Created</label></div>");
				$('.route_create_date').append("<div id='route_create_date' class='input'>" + route.route_create_date + "</div></div>");
				
				$('#routeForm').append("<div class='clearfix route_update_date'></div>");
				$('.route_update_date').append("<label for='route_update_date'>Last updated</label></div>");
				$('.route_update_date').append("<div id='route_update_date' class='input'>" + route.route_update_date + "</div></div>");

				// Popup modal panel
				$('#modal-route-save').modal('toggle');
			} else {
				alert("Nothing is returned.");
			}
		});
	},
	routeDelete : function(route_id) {
		$('#delete_id').val(route_id);
		$('#modal-route-delete').modal('toggle')
	}
};