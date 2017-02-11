if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(document).ready(function(){
	replaceMailAddress();
});

function replaceMailAddress(){
	var username = "info"; 
	var hostname = "grailsgroup.ch"; 
	var linktext = "mail"; 
	$('.mailAdd').html('<a href="mailto:' + username + '@' + hostname + '">' + linktext + '<\/a>');
}