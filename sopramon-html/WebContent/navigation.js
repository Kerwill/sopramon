$('a').bind('click', function() {
	let sectionId = $(this).attr('href');
	
	$('section').hide();
	$(sectionId).show();
});