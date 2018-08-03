package fr.sopra.DAOHibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import fr.sopra.DAO.IDAOBoss;
import fr.sopra.DAO.IDAOItem;
import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Sopramon;
import fr.sopra.model.game.Type;

public class ProgrammeGenerator {

	public static void main(String[] args) throws ParseException {
		
		Scanner keyboard = new Scanner(System.in);
		
//cr�er un boss
		System.out.println("-----Cr�ation d'un boss----");
		System.out.println("Entrez le nom du boss : ");
		String nomBoss = keyboard.next();
		System.out.println("Entrez le niveau du boss : ");
		int niveauBoss = keyboard.nextInt();
		System.out.println("Entrez l'attaque du boss : ");
		int attaqueBoss = keyboard.nextInt();
		System.out.println("Entrez la defense du boss : ");
		int defenseBoss = keyboard.nextInt();
		System.out.println("Entrez les points de vie du boss : ");
		int pdvBoss = keyboard.nextInt();
		System.out.println("Entrez l'esquive du boss : ");
		int esquiveBoss = keyboard.nextInt();
		System.out.println("Entrez la vitesse du boss : ");
		int vitesseBoss = keyboard.nextInt();
		
		 System.out.println("Veuillez saisir le jour de naissance");
		 int jourNaissance = keyboard.nextInt();
		 System.out.println("Veuillez saisir le mois de naissance");
		 int moisNaissance = keyboard.nextInt();
		 System.out.println("Veuillez saisir l'annee de naissance");
		 int anneeNaissance = keyboard.nextInt();

		 System.out.println(jourNaissance+" "+moisNaissance+" "+anneeNaissance);
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		addBoss(nomBoss, niveauBoss,  attaqueBoss, defenseBoss, pdvBoss, 
				esquiveBoss, vitesseBoss, formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance));
		
		keyboard.close();
		
//cr�er un item		
		System.out.println("-----Cr�ation d'un item ----");
		System.out.println("Entrez le nom de l'item : ");
		String nomItem = keyboard.next();
		System.out.println("Entrez le prix de l'item : ");
		double prixItem = keyboard.nextDouble();
		System.out.println("Entrez l'attaque de l'item : ");
		int attaqueItem = keyboard.nextInt();
		System.out.println("Entrez la defense de l'item : ");
		int defenseItem = keyboard.nextInt();
		System.out.println("Entrez les pdv de l'item : ");
		int pdvItem = keyboard.nextInt();
		System.out.println("Entrez l'esquive de l'item : ");
		int esquiveItem = keyboard.nextInt();
		System.out.println("Entrez la vitesse de l'item : ");
		int vitesseItem = keyboard.nextInt();
		
		addItem(nomItem, prixItem, attaqueItem, defenseItem, pdvItem, esquiveItem, vitesseItem); // nom / prix / attaque / defense / pdv / esquive / vitesse

		
		DAOHibernate.close();
	}   

	public static Sopramon addSopramon(@Size(max = 30) @NotEmpty String nomUtil,
			@Size(max = 30) @NotEmpty String prenomUtil, @Size(max = 30) @NotEmpty String username,
			@Size(max = 30) @NotEmpty String password, @NotEmpty Date dateNaissance,
			@NotEmpty @Size(max = 30) String nom) {
		
		DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
		Sopramon mySopramon = new Sopramon();

		mySopramon.setNomUtil(nomUtil);
		mySopramon.setPrenomUtil(prenomUtil);
		mySopramon.setUsername(username);
		mySopramon.setPassword(password);
		mySopramon.setDateNaissance(dateNaissance);
		mySopramon.setExperience(0);
		mySopramon.setNiveau(1);
		mySopramon.setArgent(100.00d);
		mySopramon.setNom(nom);
		mySopramon.setSigne(SigneGenerator.getAstrologicalSign(dateNaissance));
		daoSopramon.save(mySopramon);

		return mySopramon;  
	}

	public static void addBoss(String nom, int niveau, int attaque, int defense, int pdv, int esquive, int vitesse, Date dateNaissance) {

		IDAOBoss daoBoss = new DAOBossHibernate();
		Boss myBoss = new Boss();

		myBoss.setNom(nom);
		myBoss.setNiveau(niveau);
		myBoss.setSigne(SigneGenerator.getAstrologicalSign(dateNaissance));
		myBoss.getCapacite().setAttaque(attaque);
		myBoss.getCapacite().setDefense(defense);
		myBoss.getCapacite().setPointsDeVie(pdv);
		myBoss.getCapacite().setEsquive(esquive);
		myBoss.getCapacite().setVitesse(vitesse);

		daoBoss.save(myBoss);
	}
	
	public static void addItem(String nom, double prix, int attaque, int defense, int pdv, int esquive, int vitesse) {

		IDAOItem daoItem = new DAOItemHibernate();
		Item myItem = new Item();

		myItem.setNom(nom);
		myItem.setPrix(prix);
		myItem.getCapacite().setAttaque(attaque);
		myItem.getCapacite().setDefense(defense);
		myItem.getCapacite().setPointsDeVie(pdv);
		myItem.getCapacite().setEsquive(esquive);
		myItem.getCapacite().setVitesse(vitesse);

		daoItem.save(myItem);
	}
	
	public static void modifyItem(String nom)  {
		DAOItemHibernate daoItem = new DAOItemHibernate();
		Item item = daoItem.findByNom(nom);	
		Scanner keyboard = new Scanner(System.in);
		
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
	

	double prixItem = keyboard.nextDouble();
	System.out.println("Entrez l'attaque de l'item : ");
	int attaqueItem = keyboard.nextInt();
	System.out.println("Entrez la defense de l'item : ");
	int defenseItem = keyboard.nextInt();
	System.out.println("Entrez les pdv de l'item : ");
	int pdvItem = keyboard.nextInt();
	
	keyboard.close();
}
}
