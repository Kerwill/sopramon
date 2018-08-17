
function appendCombat(combat) {
	let myRow = $("<tr />");
	let myColDate = $("<td />");
	let myColArene = $("<td />");
	let myColType = $("<td />");
let myColCombattant2 = $("<td />");

var date = new Date(combat.date);
	//AFFECTER LE CONTENU A MES COLONNES
	myColDate.html(date.toGMTString());
	myColArene.html(combat.arene);
	myColType.html(combat.type);
	myColCombattant2.html(combat.combattant2.nom);


	//DONNER LES COLONNES A LA LIGNE
	myRow.append(myColDate);
	myRow.append(myColArene);
	myRow.append(myColType);
myRow.append(myColCombattant2);

	//DONNER LA LIGNE AU TABLEAU
	$('#combats tbody').append(myRow);
}


	$.ajax({
		method: 'GET',
		url: 'http://192.168.1.100:8080/sopramon-web/api/combats',
		success: function(combats) {
			console.log(combats);

var superCompteur = 0;
			//AJOUT DE CHAQUE COMBAT
			for (let combat of combats) {
				superCompteur++;
				$('span').html("Il y a " + superCompteur + " combat(s) dans l'historique.");
				appendCombat(combat);

			}
		}
	});
