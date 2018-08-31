$('#popup1')(function() {
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/sopramon-web/api/sopramons",
		
		success: function(sopramons) {
			for (let sopramon of sopramons) {
				appendSopramon(sopramon);
			}
		}
	});
	
	
	
	function appendSopramon(sopramon) {
		let myRow = $('<tr />');
		let myColumnId = $('<td />');
		let myColumnPrenom = $('<td />');
		let myColumnUsername = $('<td />');
		let myColumnExperience = $('<td />');
		

		myColumnId.html(sopramon.id);
		myColumnPrenom.html(sopramon.prenom);
		myColumnUsername.html(sopramon.username);
		myColumnExperience.html(sopramon.capacite.experience);

		myRow.append(myColumnId);
		myRow.append(myColumnPrenom);
		myRow.append(myColumnUsername);
		myRow.append(myColumnExperience);
		
		$('#listSopramon tbody').append(myRow);
	}
});



$('#popup2')(function() {
	var currentItem = null;
	
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/sopramon-web/api/items",
		
		success: function(items) {
			for (let item of items) {
				appendItem(item);
			}
		}
	});
	

	function appendItem(item, replacementItem) {
		let myRow = $('<tr />');
		let myColumnId = $('<td />');
		let myColumnNom = $('<td />');
		let myColumnPrix = $('<td />');
		let myColumnCapacites = $('<td />');
		
		let myColumnActions = $('<td />');
		let myButtonEdit = $('<button class="btn btn-warning" />');
		let myButtonDelete = $('<button class="btn btn-danger" />');
		
		
		/* INFOS */
		myRow.attr('data-item-id', item.id);
		myColumnId.html(item.id);
		myColumnNom.html(item.nom);
		myColumnPrix.html(item.prix);
		myColumnCapacites.html(item.capacite.attaque + ", " + item.capacite.defense + ", " + item.capacite.esquive + ", " + item.capacite.vitesse + ", " + item.capacite.pointsDeVie);
		
		myRow.append(myColumnId);
		myRow.append(myColumnNom);
		myRow.append(myColumnPrix);
		myRow.append(myColumnCapacites);
		
		
		/* ACTIONS */
		myButtonEdit.html("Editer");
		myButtonDelete.html("Supprimer");
		
		myColumnActions.append(myButtonEdit);
		myColumnActions.append(myButtonDelete);
		
		myRow.append(myColumnActions);

		myButtonEdit.bind('click', item, editItem);
		myButtonDelete.bind('click', item, deleteItem);
		
		
		/* AJOUT DE LA LIGNE */
		if (replacementItem == null) {
			$('#items tbody').append(myRow);
		}
		
		else { //On cherche l'item à remplacer
			let myReplacementRow = $('#items tbody tr[data-item-id=' + replacementItem.id + ']');
			myRow.insertBefore(myReplacementRow);
			myReplacementRow.remove();
		}
	}
	
	
	
});