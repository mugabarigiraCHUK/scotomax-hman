/**
  * Java Script
  *
  */
$(function(){
	// load javascript function for menu.
	bmenu._init();
});

var bmenu = {
	bmenus : ["home", "note", "profile", "contacts","setting"],	
	_init : function() {
		// Button mouse over event handle.		
		$('.mbutton').hover(function(){
			$(this).addClass("mbutton_hover");
		}, function(){
			$(this).removeClass("mbutton_hover");
		});
		// Button mouse click event handle.
		$('#home').click(function(){
			alert("Entering home page.");
		});

		$('#note').click(function(){
			alert("Entering note page.");
		});

		$('#profile').click(function(){
			alert("Entering profile page.");
		});

		$('#contacts').click(function(){
			alert("Entering contact page.");
		});

		$('#setting').click(function(){
			alert("Entering setting page.");
		});
	}
};
