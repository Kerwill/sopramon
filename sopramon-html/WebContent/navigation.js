//$('a').bind('click', function() {
//	let sectionId = $(this).attr('href');
//	
//	$('section').hide();
//	$(sectionId).show();
//});
//


var audioexploration = new Audio('audio/audioexploration.mp3');
var audioexploration2 = new Audio('audio/audioexploration2.mp3');

var audiohome = new Audio('audio/audiohome.mp3');
var audioshop = new Audio('audio/audioshop.mp3');
var audiodonjon = new Audio('audio/audiodonjon.mp3');
var audioarene = new Audio('audio/audioarene.mp3');

var myArray = [audioexploration, audioexploration2];


function getRandomInt(max) {
	  return Math.floor(Math.random() * Math.floor(max));
	}

var audioplayed = myArray[getRandomInt(2)];

setTimeout(function() {
	$('.spinner').fadeOut("slow");
}, 3000);
setTimeout(function() {
	$('#jeu').fadeIn("slow");
	audioplayed.play();
}, 3500);

$(document).keydown(function(e) {

	if (e.which == 39) // Vers la droite
	{

		$('#exploresopramon').css('background-position-x', '41.7%');

		posX = parseInt($('#exploresopramon').css('left'));

		if (posX < 780) {
			$('#exploresopramon').animate({
				left : "+=10"
			}, 50).animate({
				'background-position-x' : '100%'
			}, 1).animate({
				left : "+=10"
			}, 50).animate({
				'background-position-x' : '41.7%'
			}, 1);

		}
	}

	if (e.which == 37) // Vers la gauche
	{
		$('#exploresopramon').css('background-position-x', '29%');
		posX = parseInt($('#exploresopramon').css('left'));

		if (posX > 0) {
			$('#exploresopramon').animate({
				left : "-=10"
			}, 50).animate({
				'background-position-x' : '86%'
			}, 1).animate({
				left : "-=10"
			}, 50).animate({
				'background-position-x' : '29%'
			}, 1);

		}
	}

	if (e.which == 40) // Vers le bas
	{
		$('#exploresopramon').css('background-position-x', '0%');
		posY = parseInt($('#exploresopramon').css('top'));
		if (posY < 560) {
			$('#exploresopramon').animate({
				top : "+=10"
			}, 50).animate({
				'background-position-x' : '55%'
			}, 1).animate({
				top : "+=10"
			}, 50).animate({
				'background-position-x' : '0%'
			}, 1);

		}
	}
	if (e.which == 38) // Vers le haut
	{

		$('#exploresopramon').css('background-position-x', '15%');

		posY = parseInt($('#exploresopramon').css('top'));

		if (posY > 0)

		{
			$('#exploresopramon').animate({
				top : "-=10"
			}, 50).animate({
				'background-position-x' : '70%'
			}, 1).animate({
				top : "-=10"
			}, 50).animate({
				'background-position-x' : '15%'
			}, 1)

		}
	}

	setTimeout(function() {
		entrerDonjon()
	}, 5);
	setTimeout(function() {
		entrerMagasin()
	}, 5);
	;
	setTimeout(function() {
		entrerMaison()
	}, 5);
	setTimeout(function() {
		entrerArene()
	}, 5);
	;

});

function entrerDonjon() {

	posX = parseInt($('#exploresopramon').css('left'));
	posY = parseInt($('#exploresopramon').css('top'));

	elemX = parseInt($('#donjon').css('left'));
	elemY = parseInt($('#donjon').css('top'));

	if ((posX + 10 < elemX + 85 + 10) && (posX + 10 > elemX + 85 - 10)
			&& (posY + 30 > elemY + 150 - 10) && (posY + 30 < elemY + 150 + 10)) {
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		alert("ok donjon");
		audiodonjon.play();

	}
};

function entrerMagasin() {

	posX = parseInt($('#exploresopramon').css('left'));
	posY = parseInt($('#exploresopramon').css('top'));

	elemX = parseInt($('#shop').css('left'));
	elemY = parseInt($('#shop').css('top'));

	if ((posX + 10 < elemX + 75 + 10) && (posX + 10 > elemX + 75 - 10)
			&& (posY + 30 > elemY + 78 - 10) && (posY + 30 < elemY + 78 + 10)) {
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		alert("ok magasin");
		audioshop.play();

	}
};

function entrerMaison() {

	posX = parseInt($('#exploresopramon').css('left'));
	posY = parseInt($('#exploresopramon').css('top'));

	elemX = parseInt($('#home').css('left'));
	elemY = parseInt($('#home').css('top'));

	if ((posX + 10 < elemX + 49 + 10) && (posX + 10 > elemX + 49 - 10)
			&& (posY + 30 > elemY + 94 - 10) && (posY + 30 < elemY + 94 + 10)) {
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		alert("ok maison");
		audiohome.play();

	}
};


function entrerArene() {

	posX = parseInt($('#exploresopramon').css('left'));
	posY = parseInt($('#exploresopramon').css('top'));

	elemX = parseInt($('#arene').css('left'));
	elemY = parseInt($('#arene').css('top'));

	if ((posX + 10 < elemX + 94 + 10) && (posX + 10 > elemX + 94 - 10)
			&& (posY + 30 > elemY + 101 - 10) && (posY + 30 < elemY + 101 + 10)) {
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		// $('#donjon').fadeOut(1000,'swing');
		// $('#donjon').fadeIn(200,'linear');
		alert("ok arene");
		audioarene.play();

	}
};