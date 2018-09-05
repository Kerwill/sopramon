package fr.sopra.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.sopra.dao.IDAOSopramon;
import fr.sopra.model.Utilisateur;
import fr.sopra.model.game.Sopramon;

public class SigninController {

	IDAOSopramon daoSopramon;
	
	
	@GetMapping("/inscription")
	public String getLogin() {
		return "signin";
	}
	
	
	@PostMapping("/inscription")
	public String postLogin(@Valid @ModelAttribute Sopramon sopramon, BindingResult result, Model model) {
		
		
		
		
		Utilisateur checkSopramon = daoSopramon.findByNom(sopramon.getNom());
		
		if(checkSopramon != null) {
			
		result.rejectValue("username", "username.pris", "Nom d'utilisateur deja�pris");
		
		return "signin";}
		
		else {
			
			daoSopramon.save(sopramon);
			return "home";
		}
	}
}
