/*
 * Page loaded
 */
$(function() {
	$('.left-nav a').click(function(ev) {
		$('.left-nav a.selected').removeClass('selected');
		$(this).addClass('selected');
		//ev.preventDefault();
	});	
	
	$('.dataTable tr').hover(function(){
		$(this).addClass('rowhover')
		$(this).children().addClass('rowhover');
		console.log($(this).children());
	},function(){
		$(this).children().removeClass('rowhover');
		$(this).removeClass('rowhover');
		console.log($(this).children());
	});
	
	$('.command').button();
	
});