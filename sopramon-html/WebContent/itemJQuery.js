function addItem() {
	let myItem = {
		id : $('input[name="Id"]').val(),
		nom : $('input[name="Nom"]').val(),
		prix : $('input[name="Prix"]').val(),
		capacite : {
		'attaque' : $('input[name="Attaque"]').val(),
		'defense' : $('input[name="Defense"]').val(),
		'esquive' : $('input[name="Esquive"]').val(),
		'pointsDeVie' : $('input[name="Points de vie"]').val(),
		'vitesse' : $('input[name="Vitesse"]').val(),
		}
	};

	appendItem(myItem);

	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/items',
		contentType : 'application/json',
		data : JSON.stringify(myItem),
		success : function() {
			alert('success');
		}
	});
}

	


function appendItem(item) {
	let myRow = $("<tr />");
	let myColId = $("<td />");
	let myColNom = $("<td />");
	let myColPrix = $("<td />");
	let myColAttaque = $("<td />");
	let myColDefense = $("<td />");
	let myColEsquive = $("<td />");
	let myColPointsDeVie = $("<td />");
	let myColVitesse = $("<td />");

	// AFFECTER LE CONTENU A MES COLONNES
	
	myColId.html(item.id);
	myColNom.html(item.nom);
	myColPrix.html(item.prix);
	myColAttaque.html(item.capacite.attaque);
	myColDefense.html(item.capacite.defense);
	myColEsquive.html(item.capacite.esquive);
	myColPointsDeVie.html(item.capacite.pointsDeVie);
	myColVitesse.html(item.capacite.vitesse);
	

	// DONNER LES COLONNES A LA LIGNE
	
	myRow.append(myColId);
	myRow.append(myColNom);
	myRow.append(myColPrix);
	myRow.append(myColAttaque);
	myRow.append(myColDefense);
	myRow.append(myColEsquive);
	myRow.append(myColPointsDeVie);
	myRow.append(myColVitesse);

	// DONNER LA LIGNE AU TABLEAU

	$('#items tbody').append(myRow);

	// AJOUTER UNE OPTION DE SUPRESSION
	let myColSuppr = $("<button class=\"btn-del\" />");
	myColSuppr.html("Supprimer");
	myRow.append(myColSuppr);

	$('button.btn-del').bind(
			'click',
			function() {
				$(this.closest('tr')).remove();

				$.ajax({
					method : 'DELETE',
					url : 'http://192.168.1.100:8080/sopramon-web/api/items/'
							+ parseInt(item.id),
					success : function(data) {
						alert("success");
					}
				});
			});

	// AJOUTER UNE OPTION DE MODIFICATION
	
	let myColModif = $("<button class=\"btn-modify\" />");
	myColModif.html("Modifier");
	myRow.append(myColModif);
}

$('form').bind('submit', function() {
	addItem();
	return false;
});


$("#charge").bind('click', function() {
	$('tbody tr').remove();
	$.ajax({
		method : 'GET',
		url : 'http://192.168.1.100:8080/sopramon-web/api/items',
		data : {},
		success : function(data) {
			for ( let i in data) {
				console.log(data);
				appendItem(data[i]);
			}
		}
	})});


function modifyItem() {
	let myItem = {
		id : $('input[name="Id"]').val(),
		nom : $('input[name="Nom"]').val(),
		prix : $('input[name="Prix"]').val(),
		capacite : {
		'attaque' : $('input[name="Attaque"]').val(),
		'defense' : $('input[name="Defense"]').val(),
		'esquive' : $('input[name="Esquive"]').val(),
		'pointsDeVie' : $('input[name="Points de vie"]').val(),
		'vitesse' : $('input[name="Vitesse"]').val(),
		}
	};

	$.ajax({
		method : 'PUT',
		url : 'http://192.168.1.100:8080/sopramon-web/api/items/'
		+ parseInt(item.id),
		contentType : 'application/json',
		data : JSON.stringify(myItem),
		success : function() {
			alert('success');
		}
	});
}


$('button.btn-modify').bind(
		'click',
		function() {
//			modifyItem();
			alert($(this.closest('th[class="id"]')))
			return false;
		});
