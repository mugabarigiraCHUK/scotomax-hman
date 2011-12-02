var knwstatus = {
	prepareStatus : function(status_id) {
		$.post(prepareStatus({status_id: status_id}), function(status){
			if (status) {
				$('#status_id').val(status.status_id);
				$('#status_name').val(status.status_name);
				$('#status_description').val(status.status_description);
				$('#statusForm').append("<div class='clearfix status_update_date'></div>");
				$('.status_update_date').append("<label for='status_update_date'>Last updated</label></div>");
				$('.status_update_date').append("<div class='input'><input class='xlarge' id='status_update_date' name='status_update_date' size='30' type='text' disabled='disabled' value='"+status.status_update_date+"'/></div></div>");
									        
				// Popup modal panel
				$('#modal-from-dom').modal('toggle');
			} else {
				$('#status_id').val('');
				$('#status_name').val('');
				$('#status_description').val('');
				$('.status_update_date').remove();
			}
		});
	},
	deleteStatus : function(status_id) {
		$('#delete_id').val(status_id);
		$('#modal-from-delete').modal('toggle')
	}
};