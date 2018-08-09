package fr.sopra;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.idao.IDAOAchat;
import fr.sopra.idao.IDAOCapacite;
import fr.sopra.idao.IDAOCombat;
import fr.sopra.idao.IDAOCoup;
import fr.sopra.idao.IDAOItem;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Sopramon;
import fr.sopra.service.ServiceSopramon;

@Transactional
public class MenuSopramon {

	@Autowired
	private IDAOItem daoItem;
	@Autowired
	private IDAOSopramon daoSopramon;
	@Autowired
	private IDAOAchat daoAchat;

	@Autowired
	private IDAOCombat daoCombat;
	@Autowired
	private IDAOCoup daoCoup;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ServiceSopramon serviceSopramon;

	@Transactional
	public void menu(Sopramon sopramon) {

		System.out.println("--------------------------Vos caracteristiques----------------------- \n"
				+ "Nom du Sopramon : " + sopramon.getNom() + "\n" + "Date de Naissance : " + sopramon.getDateNaissance()
				+ "\n" + "Signe : " + sopramon.getSigne() + "\n" + "Type : " + sopramon.getType() + "\n"
				+ "Experience : " + sopramon.getExperience() + "\n" + "Niveau : " + sopramon.getNiveau() + "\n"
				+ "PV : " + sopramon.getCapacite().getPointsDeVie() + "\n" + "Attaque : "
				+ sopramon.getCapacite().getAttaque() + "\n" + "Defense : " + sopramon.getCapacite().getDefense() + "\n"
				+ "Vitesse : " + sopramon.getCapacite().getVitesse() + "\n" + "Esquive : "
				+ sopramon.getCapacite().getEsquive() + "\n" + "Argent : " + sopramon.getArgent() + "\n" + "Defense : "
				+ sopramon.getCapacite().getAttaque() + "\n");
	}
	
	

    
    @Transactional
    public void besace(Sopramon sopramon) {

		
        System.out.println("--------------------------Vos achats----------------------- \n");
        for (Achat a : serviceSopramon.getAchats()) {
            System.out.println("nom : "+a.getItem().getNom()+ " prix d'achat : "+a.getPrix()+" Capacites : "+ a.getItem().getCapacite().description());
        }

	}
	
	
    public void listeCoupsEtCombat(Sopramon sopramon) {
    	
//    	System.out.println("--------------------------Vos coups ----------------------- \n");
//    	for (Coup c : serviceSopramon.getCoups())
//    	{
//    		System.out.println("Degat : "+c.getDegats()+ " Date : "+c.getDate());
//    	}
    	
    	
    	System.out.println("--------------------------Vos 10 derniers coups ----------------------- \n");
    	
 
//    	for (Coup c : serviceSopramon.getCoups())
//    	{
//    		System.out.println("Degat : "+c.getDegats()+ " Date : "+c.getDate());
//    	}
    	
    	 for (Coup c : daoCoup.findTop10BySopramonOrderByIdDesc(sopramon))
     	{
     		System.out.println("Degat : "+c.getDegats()+ " Date : "+c.getDate());
     	}
    	 
    	 System.out.println("--------------------------Vos 10 derniers combats----------------------- \n");
    	 
    	 for (Combat cb : daoCombat.findTop10BySopramon1OrSopramon2OrderByIdDesc(sopramon,sopramon))
      	{
      		System.out.println("Nbre de tour "+ cb.getTour()+ "Opposant Boss : "+cb.getBoss()+ "Opposant sopramon : "+cb.getAttaquant2());
      	}
    		
    }
}
