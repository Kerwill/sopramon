package fr.sopra.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Sopramon;

@Service
@Transactional
public class ServiceSopramon {
	
	@Autowired
	private IDAOUtilisateur daoUser;
	
	private Sopramon sopramon;
	
	
	public Sopramon connect(String username, String password) {
		sopramon = (Sopramon) daoUser.findByUsernameAndPassword(username, password);
		return sopramon;
	}
	
	public List<Achat> getAchats() {
		sopramon = daoUser.save(sopramon);
		return sopramon.getAchats();
	}
}
