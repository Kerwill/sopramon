//inscription
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

			alert("Votre inscription a été validée")

		}
	});

};


//connexion 




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
			
			alert("connexion");
			
			console.log(data);
			appendSopramon(data);
		}
	})
};


function appendSopramon(sopramon) {
	
	let myRow = $('<tr />');
	let myColNom = $('<td />');
	let myColPrix = $('<td />');
	let myColGamme = $('<td />');
	
	
	myColNom.html(sopramon.username);
	myColPrix.html(sopramon.signe);
	myColGamme.html(sopramon.dateNaissance);
	
	myRow.append(myColNom);
	myRow.append(myColPrix);
	myRow.append(myColGamme);


	$('#sopramon tbody').append(myRow);

}


