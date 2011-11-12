/*!
 * iCall - Main JavaScript file content 
 * which will be loaded every page (main template). 
 * 
 */
 $(function(){
 	// Click event-handle to remove error message notification bar
 	$("#error-close").click(function(){
 		$("#error-message").fadeOut();
 	});
 	
 	// Click event-handle to remove error message notification bar
 	$("#warn-close").click(function(){
 		$("#warn-message").fadeOut();
 	});

 	// Click event-handle to remove error message notification bar
 	$("#info-close").click(function(){
 		$("#info-message").fadeOut();
 	});
 });