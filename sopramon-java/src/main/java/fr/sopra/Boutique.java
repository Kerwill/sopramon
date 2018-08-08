package fr.sopra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.idao.IDAOAchat;
import fr.sopra.idao.IDAOItem;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Item;

@Component
public class Boutique {
	@Autowired
	private IDAOItem daoItem;
	@Autowired
	private IDAOSopramon daoSopramon;
	@Autowired
	private IDAOAchat daoAchat;

	@Transactional
	public void shopping(String[] args) {
		System.out.println("Bienvenue à la boutique !");
		System.out.println("Vous trouverez ici la liste des items que nous vendons : ");
		for (Item i : daoItem.findAll()) {
			System.out.println(i.getNom());
		}
}
}