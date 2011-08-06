/*
 * ************ On template be loaded ****************
 */
$(function(){
	$(".cmdLogin").click(function(){
		window.location.href='login.faces';
	});
	
	$("#myphone").click(function(){
		alert('Go to My Phone information page.');
	});
	
	$("#datacenter").click(function(){
		alert('Go to Data Center information page.');
	});
	
	$("#mycalendar").click(function(){
		alert('Go to My Calendar information page.');
	});
	
	$("#myagent").click(function(){
		alert('Go to My Agent information page.');
	});
	
	$("#myjob").click(function(){
		alert('Go to My Jobs information page.');
	});
	
});

/*
 * *********** Page loading **************
 * 
 */
var appage = 
{
	onLoad:function(data) {
		if (data.status == 'begin') {
			$(".loading-screen", this.element).show();
	    	$(".loading-screen", this.element).css({opacity: 0.80});
	    	$(".loading-screen", this.element).width($(document).width());
	    	$(".loading-screen", this.element).height($(document).height());
		} else if ( data.status == 'complete' || data.status == 'success' ) {
			$(".loading-screen", this.element).hide();
		} 
	}
};