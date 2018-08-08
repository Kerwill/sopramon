package fr.sopra;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.idao.IDAOAchat;
import fr.sopra.idao.IDAOItem;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Sopramon;

@Component
public class Boutique {
	@Autowired
	private IDAOItem daoItem;
	@Autowired
	private IDAOSopramon daoSopramon;
	@Autowired
	private IDAOAchat daoAchat;

	@Transactional
	public void shopping(Sopramon sopramon, Scanner keyboard) {
		
		try {
			System.out.println(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Bienvenue à la boutique " + sopramon.getUsername() + " !");
		System.out.println("Vous trouverez ici la liste des items que nous vendons : ");
		for (Item i : daoItem.findAll()) {
			System.out.println(i.getNom() + " : " + i.getPrix() + "£");
		}
		System.out.println("Quel item désirez-vous acquérir ?");
		String nom = keyboard.next();
		Item itemVoulu = daoItem.findByNom(nom);
		double porteMonnaie = sopramon.getArgent();

		if (itemVoulu.getPrix() <= porteMonnaie) {
			Achat myAchat = new Achat();
			myAchat.setItem(itemVoulu);
			myAchat.setPrix(itemVoulu.getPrix());
			myAchat.setSopramon(sopramon);
			System.out.println("Vous avez acheté un(e) " + itemVoulu.getNom() + " au prix de " + itemVoulu.getPrix() + "£ !");
			sopramon.setArgent(porteMonnaie - itemVoulu.getPrix());
			daoSopramon.save(sopramon);
			daoAchat.save(myAchat);
			keyboard.close();
		}
		else {
			System.out.println("Vous êtes trop pauvre pour vour offrir cette merveille...retournez au combat !");
			keyboard.close();
		}
	}

}
