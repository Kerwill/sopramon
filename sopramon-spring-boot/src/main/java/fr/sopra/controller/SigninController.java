package fr.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.sopra.dao.IDAOSopramon;
import fr.sopra.dao.IDAOUtilisateur;
import fr.sopra.model.Utilisateur;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Sopramon;

@Controller
public class SigninController {

	@Autowired
	private IDAOSopramon daoSopramon;

	@Autowired
	private IDAOUtilisateur daoUtilisateur;

	@GetMapping("/inscription")
	public String getSignin() {
		return "signin";
	}
	
	
	@ModelAttribute("sopramon")
	public Sopramon sopramon() {
		return new Sopramon();
	}
	
	
//	@PostMapping("/inscription")
//	public String getSignin(@ModelAttribute Sopramon sopramon) {
//		daoSopramon.save(sopramon);
//		return "home";
//	}

	@PostMapping("/inscription")
	public String postLogin(@Valid @ModelAttribute("sopramon") Sopramon sopramon, BindingResult result, Model model) {

		Utilisateur checkSopramon = daoUtilisateur.findByUsername(sopramon.getUsername());

		if (checkSopramon != null) {

			result.rejectValue("username", "username.pris", "Nom d'utilisateur deja pris");
			
			return "signin";

//		return "redirect:inscription";
			}
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encodedPassword = passwordEncoder.encode(sopramon.getPassword());
		 sopramon.setPassword(encodedPassword);
		 
		daoSopramon.save(sopramon);
		return "home";

	}
}