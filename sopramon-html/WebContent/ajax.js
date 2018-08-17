$('a').bind('click', function() {
	let sectionId = $(this).attr('href');

	$('section').hide();
	$(sectionId).show();
});

// inscription
var mySubmission = $('#inscription');
mySubmission.bind('submit', function() {
	
		inscription();
	
	return false;

});

function inscription() {

	var myUser = {
		username : $('#inscription > input[name = "username"]').val(),
		prenom : $('#inscription > input[name = "firstname"]').val(),
		nom : $('#inscription >input[name = "surname"]').val(),
		password : $('#inscription > input[name = "password"]').val(),
		dateNaissance : $('#inscription >input[name = "birthdate"]').val()
	}

	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
		// contentType : 'application/json',
		// data : JSON.stringify(myUser),
		data : myUser,

		success : function() {

			alert("Votre inscription a été validée");
			document.location.href = "index2arnaud.html";

		}
	
	});

};

// connexion

var myConnexion = $("#connexion");
myConnexion.bind('submit', function() {
	connexion();
	return false;
});

function connexion() {

	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/auth',
		data : {
			username : $('#connexion > input[name = "username"]').val(),
			password : $('#connexion > input[name = "password"]').val()
		},

		success : function(data) {
			document.location.href = "menusopramon.html";
			alert("Vous êtes connecté");

			console.log(data);
			appendSopramon(data);
		},
		error : function(){alert("Nom d'utilisateur ou mot de passe erroné, merci de recommencer");}
	})
};

function appendSopramon(sopramon) {

	let myRow = $('<tr />');
	let myColUsername = $('<td />');
	let myColSigne = $('<td />');
	let myColDateNaissance = $('<td />');
	let myColExperience = $('<td />');
	let myColNiveau = $('<td />');
	let myColAttaque = $("<td />");
	let myColDefense = $("<td />");
	let myColEsquive = $("<td />");
	let myColPointsDeVie = $("<td />");
	let myColVitesse = $("<td />");

	myColUsername.html(sopramon.username);
	myColSigne.html(sopramon.signe);
	myColDateNaissance.html(sopramon.dateNaissance);
	myColExperience.html(sopramon.experience);
	myColNiveau.html(sopramon.niveau);
	myColAttaque.html(sopramon.capacite.attaque);
	myColDefense.html(sopramon.capacite.defense);
	myColEsquive.html(sopramon.capacite.esquive);
	myColPointsDeVie.html(sopramon.capacite.pointsDeVie);
	myColVitesse.html(sopramon.capacite.vitesse);

	myRow.append(myColUsername);
	myRow.append(myColSigne);
	myRow.append(myColDateNaissance);
	myRow.append(myColNiveau);
	myRow.append(myColExperience);
	myRow.append(myColAttaque);
	myRow.append(myColDefense);
	myRow.append(myColEsquive);
	myRow.append(myColPointsDeVie);
	myRow.append(myColVitesse);

	$('#sopramon tbody').append(myRow);

}
