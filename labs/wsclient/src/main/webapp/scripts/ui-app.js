$(function(){
	// Accordion
	$("#accordion").accordion({ header: "h3" });
	// Autocomplete
	$("#autocomplete").autocomplete({
		source: ["c++", "java", "php", "coldfusion", "javascript", "asp", "ruby", "python", "c", "scala", "groovy", "haskell", "perl"]
	});
	// Button
	$("#button").button();
	$("#radioset").buttonset();
	// Tabs
	$('#tabs').tabs();
	// Dialog			
	$('#dialog').dialog({
		autoOpen: false,
		width: 600,
		buttons: {
			"Ok": function() { 
				$(this).dialog("close"); 
			}, 
			"Cancel": function() { 
				$(this).dialog("close"); 
			} 
		}
	});
	// Dialog Link
	$('#dialog_link').click(function(){
		$('#dialog').dialog('open');
		return false;
	});
	// Datepicker
	$('#datepicker').datepicker({
		inline: true
	});
	// Slider
	$('#slider').slider({
		range: true,
		values: [17, 67]
	});
	// Progressbar
	$("#progressbar").progressbar({
		value: 20 
	});
	//hover states on the static widgets
	$('#dialog_link, ul#icons li').hover(
		function() { $(this).addClass('ui-state-hover'); }, 
		function() { $(this).removeClass('ui-state-hover'); }
	);
	
	$(".radio1").click(function(){
		window.location.href='info.faces';
	});
	
	$(".radio5").click(function(){
		window.location.href='testrm.faces';
	});
});


/*
 * *********** Page loading **************
 * 
 */
var pages = 
{
	onLoad:function(data) {
		if (data.status == 'begin') {
			$(".loading-screen", this.element).show();
	    	$(".loading-screen", this.element).css({opacity: 0.80});
	    	$(".loading-screen", this.element).width($(document).width());
	    	$(".loading-screen", this.element).height($(document).height());
		} else if ( data.status == 'complete' || data.status == 'success' ) {
			$(".loading-screen", this.element).hide();
			// Accordion
			$("#accordion").accordion({ header: "h3" });
		} 
	}
};