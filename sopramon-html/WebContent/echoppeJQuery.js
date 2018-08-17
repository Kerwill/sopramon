
function appendItem(item) {
	let myRow = $("<tr />");

	let myColNom = $("<td />");
	let myColPrix = $("<td />");
	let myColAttaque = $("<td />");
	let myColDefense = $("<td />");
	let myColEsquive = $("<td />");
	let myColPointsDeVie = $("<td />");
	let myColVitesse = $("<td />");

	// AFFECTER LE CONTENU A MES COLONNES

	myColNom.html(item.nom);
	myColPrix.html(item.prix);
	myColAttaque.html(item.capacite.attaque);
	myColDefense.html(item.capacite.defense);
	myColEsquive.html(item.capacite.esquive);
	myColPointsDeVie.html(item.capacite.pointsDeVie);
	myColVitesse.html(item.capacite.vitesse);
	

	// DONNER LES COLONNES A LA LIGNE
	

	myRow.append(myColNom);
	myRow.append(myColPrix);
	myRow.append(myColAttaque);
	myRow.append(myColDefense);
	myRow.append(myColEsquive);
	myRow.append(myColPointsDeVie);
	myRow.append(myColVitesse);

	// DONNER LA LIGNE AU TABLEAU

	$('#items tbody').append(myRow);
	
	let myColBuy= $("<button class=\"btn-buy\" />");
	myColBuy.html("Acheter");
	myRow.append(myColBuy);

}
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
	});