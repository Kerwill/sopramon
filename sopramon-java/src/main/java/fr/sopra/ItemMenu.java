package fr.sopra;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.idao.IDAOItem;
import fr.sopra.model.game.Item;

@Component
public class ItemMenu {
	@Autowired
	private IDAOItem daoItem;

	public void createItem(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("-----Creation d'un item ----");
		System.out.println("Entrez le nom de l'item : ");
		String nomItem = keyboard.next();
		System.out.println("Entrez le prix de l'item : ");
		double prixItem = keyboard.nextFloat();
		System.out.println("Entrez l'attaque de l'item : ");
		int attaqueItem = keyboard.nextInt();
		System.out.println("Entrez la defense de l'item : ");
		int defenseItem = keyboard.nextInt();
		System.out.println("Entrez les pdv de l'item : ");
		int pdvItem = keyboard.nextInt();
		System.out.println("Entrez l'esquive l'item : ");
		int esquiveItem = keyboard.nextInt();
		System.out.println("Entrez vitesse de l'item : ");
		int vitesseItem = keyboard.nextInt();

		Item myItem = new Item();

		myItem.setNom(nomItem);
		myItem.setPrix(prixItem);
		myItem.getCapacite().setAttaque(attaqueItem);
		myItem.getCapacite().setDefense(defenseItem);
		myItem.getCapacite().setPointsDeVie(pdvItem);
		myItem.getCapacite().setEsquive(esquiveItem);
		myItem.getCapacite().setVitesse(vitesseItem);
		System.out.println(myItem.toString());
		daoItem.save(myItem);

		keyboard.close();

	}

	public void readItem(String[] args) {
		for (Item i : daoItem.findAll()) {
			System.out.println(i.getNom());
		}
	}

	public void updateItem(String[] args)  {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Quel item voulez-vous modifier ?");
		String nom = keyboard.next();
		Item item = daoItem.findByNom(nom);	
		
		
	System.out.println("Quelle param�tre voulez-vous modifier ?\n"
			+ "0 : le nom \n"
			+ "1 : prix \n"
			+"2 : PV\n"
			+"3: Attaque\n"
			+ "4 : Defense\n"
			+ "5 : Esquive\n"
			+ "6: Vitesse\n");
	
	int choix = keyboard.nextInt();

	switch (choix)
	{
	  case 0:
	    System.out.println("Entrer le nouveau nom");
	    String nouveauNom = keyboard.next();
	    item.setNom(nouveauNom);
	    daoItem.save(item);
	    break;
	    
	  case 1 :
		  System.out.println("Entrer le nouveau prix");
		    Double nouveauPrix = keyboard.nextDouble();
		    item.setPrix(nouveauPrix);
		    daoItem.save(item);
	    break;
	    
	  case 2 :
		  
		 System.out.println("Entrer le nouveau PV");
		    int nouveauPV = keyboard.nextInt();
		    item.getCapacite().setPointsDeVie(nouveauPV);
		    daoItem.save(item);
	    break;
	    
	  case 3 :
		  
			 System.out.println("Entrer la nouvelle attaque");
			    int nouveauAttaque = keyboard.nextInt();
			    item.getCapacite().setAttaque(nouveauAttaque);
			    daoItem.save(item);
		    break;
		    
		    
	  case 4 :
		  
			 System.out.println("Entrer la nouvelle d�fense");
			    int nouveauDefense = keyboard.nextInt();
			    item.getCapacite().setDefense(nouveauDefense);
			    daoItem.save(item);
		    break;
		    
	  case 5 :
		  
			 System.out.println("Entrer la nouvelle esquive");
			    int nouvelleEsquive= keyboard.nextInt();
			    item.getCapacite().setEsquive(nouvelleEsquive);
			    daoItem.save(item);
		    break;
		    
	  case 6 :
		  
			 System.out.println("Entrer la nouvelle vitesse");
			    int nouvelleVitesse = keyboard.nextInt();
			    item.getCapacite().setPointsDeVie(nouvelleVitesse);
			    daoItem.save(item);
		    break;
	 
	}

	keyboard.close();

}
	
	public void deleteItem(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Quel item voulez-vous supprimer ?");
		String nom = keyboard.next();
		Item item = daoItem.findByNom(nom);
		daoItem.delete(item);
		}
	}


