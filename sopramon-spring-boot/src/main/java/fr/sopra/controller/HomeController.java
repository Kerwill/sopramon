package fr.sopra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOSopramon;
import fr.sopra.dao.IDAOUtilisateur;
import fr.sopra.model.Administrateur;
import fr.sopra.model.Utilisateur;
import fr.sopra.model.game.Sopramon;

@Controller
public class HomeController {

	// Déclaration des DAOS

	@Autowired
	IDAOUtilisateur daoUser;

	@Autowired
	IDAOSopramon daoSopramon;

	// déclaration des model Attribute
	@ModelAttribute("utilisateur")
	public Utilisateur initUtilisateur() {
		return new Utilisateur();
	}

	@ModelAttribute("administrateur")
	public Utilisateur initAdministrateur() {
		return new Administrateur();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/administrateur")
	public String login(@Valid @ModelAttribute Administrateur administrateur, BindingResult result, Model model) {
		return "admin";
		}
	

	@GetMapping("/menuSopramon")
	public String login(@Valid @ModelAttribute Sopramon sopramon, BindingResult result, Model model) {

		return "menuSopramon";
	}

	// accueil

	@GetMapping("/home")
	public String getHome(@RequestParam(required=false) String error, Model model) {
		
		if(error == null) {
			System.out.println("null");
			return "home";
		}
		
		if (error.equals("banned")) {
			
			model.addAttribute("error", "Votre compte est banni");

		}
		else if (error.equals("identification")) {
			model.addAttribute("error","Votre mot de passe ou votre username est erroné" );
	
		}
		return "home";
	}
	

	@RequestMapping(value="/deconnexion", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	   org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "home";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
}
//	