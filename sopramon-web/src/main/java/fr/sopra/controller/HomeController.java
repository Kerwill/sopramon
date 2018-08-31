package fr.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.sopra.idao.IDAOSopramon;
import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.Administrateur;
import fr.sopra.model.Utilisateur;

@Controller
public class HomeController {

	@Autowired
	IDAOUtilisateur daoUser;

	@Autowired
	IDAOSopramon daoSopramon;

	@GetMapping("/home")
	public String getHome(Model model) {
		return "home";
	}

	@ModelAttribute("utilisateur")
	public Utilisateur initUtilisateur() {
		return new Utilisateur();
	}

	@ModelAttribute("administrateur")
	public Utilisateur initAdministrateur() {
		return new Administrateur();
	}

	@PostMapping("/home")
	public String login(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult result, Model model) {

		Utilisateur checkUser = daoUser.findByUsernameAndPassword(utilisateur.getUsername(),utilisateur.getPassword());
		
		if (checkUser == null) {
		result.rejectValue("username.empty", "Nom ou mot de passe erroné");
		return "home";
		}
		
		if (checkUser.getAccess() = 1)
		{
			result.reject("Nom ou mot de passe erroné");
			return "home";
			}
		
		else
		{
			model.addAttribute("sopramon", daoSopramon.findById(utilisateur.getId()));
			return "menuSopramon";
		}

		
		
		}

}

//	if (bindingResult.hasErrors()) {
//        model.addAttribute("form", form)
//        return "app/customers/create"
