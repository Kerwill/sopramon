package fr.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	public String getHome() {
		return "home";
	}


	
}
//	@GetMapping("/utilisateur")
//	public String login(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult result, Model model) {
//
//		Utilisateur checkUser = daoUser.findByUsernameAndPassword(utilisateur.getUsername(), utilisateur.getPassword());
//
//		if (checkUser == null) {
//			result.rejectValue("username", "username.errone", "Nom ou mot de passe errone");
//
//			return "home";
//		}
//
//		else if (checkUser.getAccess() == 1) {
//			result.rejectValue("username", "username.banni", "Vous �tes banni");
//
//			return "home";
//		}
//
//		else {
//			System.out.println("ok");
////			session.setAttribute("utilisateur", checkUser);
//			return "menuSopramon";
//		}
//
//	}
//
//	
//
//		else {
//			result.rejectValue("admin", "username.errone", "Nom ou mot de passe erron�");
//			return "home";
//		}
//	}
//
//}
//
////	
////	 @GetMapping("/logout")
////	    public String logout(Model model) {
////	        return "logout";
////	    }
//
////	if (bindingResult.hasErrors()) {
////        model.addAttribute("form", form)
////        return "app/customers/create"
//
//
//
//
//
//
//
