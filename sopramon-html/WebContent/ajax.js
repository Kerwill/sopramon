
//inscription
	var mySubmission = $('form #inscription');
	mySubmission.bind('submit', function() {

		inscription();
		return false;
		
		
	});
function inscription() {



	
	var myUser = {
			username : $('form #inscription input[name = "username"]').val(),
			prenom : $('form #inscription input[name = "firstname"]').val(),
			nom : $('form #inscription input[name = "surname"]').val(),
			password : $('form #inscription input[name = "password"]').val(),
			dateNaissance: $('form #inscription input[name = "birthdate"]').val()
	}
	

	
	
	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
		// contentType : 'application/json',
		// data : JSON.stringify(myUser),
		data: myUser,

		success : function() {
			
			alert("Votre inscription a été validée")

		}
	});

	};

	

	
	var myConnexion = $('form #connexion');
	mySubmission.bind('submit', function() {

		connexion();
		return false;
	});
	
	
	
	function connexion() {
	
	$.ajax({
				method : 'POST',
				url : 'http://192.168.1.100:8080/sopramon-web/api/auth',
				data: {
					username: $('form #connexion input[name = "username"]').val(),
					password: $('form #connexion input[name = "password"]').val()
					},
				
				success : function() {
					alert("Connexion");
				}
			})};
	


		