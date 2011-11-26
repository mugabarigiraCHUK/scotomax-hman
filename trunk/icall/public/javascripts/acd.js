/* 
 * ACD Condition
 * - JavaScript functions
 * @html /views/AutoCallDistributors/condition.html
 *
 * @author Sarayut Utsakoo
 *
 */
var ria = {
	funcEdit : function(cond_id) {
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
	funcDelete : function(cond_id) {
		$('#delete_id').val(cond_id);
		$('#modal-from-delete').modal('toggle')
	}
};