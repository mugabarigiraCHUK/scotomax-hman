var loadingscreen  = 
{   
     _init: function() 
     {
		console.log('Entering loadingscreen._init()...');
		var opts = this.options;	
		var element = this.element;
		var id = element[0].id;
		var _this = this;
		
		var html =	"<div class='loading-screen'>" +
						"<div class='loading-screen-icon'></div>"+
					"</div>";
		element.append(html);
     },
     show: function(){
    	 console.log('Entering loadingscreen.show()...');
    	 $(".loading-screen", this.element).show();
    	 $(".loading-screen", this.element).css({opacity: 0.80});
     },
     hide: function(){
    	 console.log('Entering loadingscreen.hide()...');
    	 $(".loading-screen", this.element).hide();
     }
};

$.widget("ui.loadingscreen", loadingscreen);

$.ui.loadingscreen.defaults = 
{ 
	
};