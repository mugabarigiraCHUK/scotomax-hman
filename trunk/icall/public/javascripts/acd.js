$(function(){
	// Table sorter
	$("table#acd-condition").tablesorter({ sortList: [[0,0], [1,0]], headers: { 2:{sorter: false}, 4:{sorter: false}, 5:{sorter: false}} });
	// Modal panel
	$("#modal-from-dom").modal({
		keyboard: true
	});

});