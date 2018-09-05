$('.overlay').hide();

var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 5000); // Change image every 2 seconds
}


var myConnexionAdmin = $("#boutonadminconnexion");
myConnexionAdmin.bind('click', function() {
	$('.overlay').fadeIn("slow");
	$(document).mouseup(function(e) {
		var container = $('#adminconnexion');

		// if the target of the click isn't the container nor a descendant of
		// the container
		if (!container.is(e.target) && container.has(e.target).length === 0) {
			$('.overlay').fadeOut("slow");
			$('.overlay').container.hide();
		}
	});
}

)