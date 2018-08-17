

// $('form').bind('submit', function() {
// 	addProduit();
// 	return false;
// });


//$('a').bind('click', function() {
//	$('form').remove();
//	return false;
//});

//$('tr').bind('click', function() {
//	$('table').remove();
//});

//$('tr').bind('click', function() {
//	$(this).remove();
//});




$('button.btn-clear').bind('click', function() {
	$('tbody tr').remove();
});



// function addProduit() {
// 	let myProduit = {
// 		nom: $('input[name="nom"]').val(),
// 		prix: $('input[name="prix"]').val(),
// 		gamme: {
// 			id: $('select[name="gamme_id"]').val()
// 		}
// 	};

	// $.ajax({
	// 	method: 'POST',
	// 	url: 'http://192.168.1.100:8080/ewavy-web/api/produits',
	// 	contentType: 'application/json',
	// 	data: JSON.stringify(myCombat), //EN JSON
	// 	success: function(combat) {
	// 		appendCombat(combat);
	// 	}
	// });



	//GESTION DU COMPTEUR
//	superCompteur++;
//	$('span').html(superCompteur);
// 	$('span').html(++superCompteur);
// }


// function appendProduit(produit) {
// 	let myRow = $("<tr />");
// 	let myColNom = $("<td />");
// 	let myColPrix = $("<td />");
// 	let myColGamme = $("<td />");
// 	let myColAction = $("<td />");
// 	let myButtonDelete = $("<button />");

function appendCombat(combat) {
	let myRow = $("<tr />");
	let myColId = $("<td />");
	let myColDate = $("<td />");
	let myColArene = $("<td />");
	let myColType = $("<td />");
let myColCombattant1 = $("<td />");
let myColCombattant2 = $("<td />");
let myColCoups = $("<td />");


	let myColAction =$("<td />");
	let myButtonDelete = $("<button />");

var compteurCoup=0;
var date = new Date(combat.date);
	//AFFECTER LE CONTENU A MES COLONNES
	myColId.html(combat.id);
	myColDate.html(date.toGMTString());
	myColArene.html(combat.arene);
	myColType.html(combat.type);
	myColCombattant1.html(combat.combattant1.nom);
	myColCombattant2.html(combat.combattant2.nom);

	//for (let i = 0; i< combat[i].coups.length; i++){
  //	console.log(i);
// 	var i=0;
//   console.log(combat.coups[0]);
// for (let i = 0; i< combat.coups[i].length; i++){
// 		if(combat.coups[i] =! undefined){
// 	myColCoupsId.html(combat.coups[i].attaquant.nom + " fait " + combat.coups[i].attaquant.degats + " de dégats à " + combat.coups[i].victime.nom );/* faire boucle pour afficher les coups dans une table scrollable : attaquant, degats, victime, pv, */
// }
// }

// CA MARCHE PAS ! AFFICHE LES COUPES D'1 seul combat.
combat.coups.forEach(function(element, i) {
  // console.log('Element', i, 'is', element);
	myColCoups.html(i + combat.coups[i].attaquant.nom + " fait " + combat.coups[i].degats + " de dégats à " + combat.coups[i].victime.nom );

});


//	myColCoupsId.html(JSON.stringify(combat.coups[0].attaquant.nom));/* faire boucle pour afficher les coups dans une table scrollable : attaquant, degats, victime, pv, */

//}
	//myColAction.append(myButtonDelete);

	//GESTION DU BOUTON
	myButtonDelete.html("SUPPRIMER");
	myButtonDelete.bind('click', function() {
		$(this).closest('tr').remove();
	});

	//DONNER LES COLONNES A LA LIGNE
	myRow.append(myColId);
	myRow.append(myColDate);
	myRow.append(myColArene);
	myRow.append(myColType);
myRow.append(myColCombattant1);
myRow.append(myColCombattant2);

myRow.append(myColCoups);

	myRow.append(myColAction);
	//DONNER LA LIGNE AU TABLEAU
	$('#combats tbody').append(myRow);
}




//CHARGER LES COMBATS
// $('button.btn-load').bind('click', function() {
// 	$('tbody tr').remove();

$.ajax({
        method : 'GET',
        url : 'http://192.168.1.100:8080/sopramon-web/api/combats',
        data : {},
        success : function(data) {
            for ( let i in data) {

                appendCombat(data[i]);
            }
						console.log(data);
        }
    });


	// $.ajax({
	// 	method: 'GET',
	// 	url: 'http://192.168.1.100:8080/sopramon-web/api/combats',
	// 	data: {},
	// 	success: function(data) {
	// 		console.log(data);
	// 		console.log(data[0].coups.length);
	//
	// 		//AJOUT DE CHAQUE COMBAT
	// 		for (let i of data) {
	//
	// 			$('span').html("Il y a " + i + " combat(s) dans l'historique.");
	// 			appendCombat(data[0]);
	// 			// for (let i = 0; i< combats[superCompteur].coups.length; i++){
	// 			// 	console.log(superCompteur);
	// 			//}
	//
	// 		}
	// 	}
	// });
//});
