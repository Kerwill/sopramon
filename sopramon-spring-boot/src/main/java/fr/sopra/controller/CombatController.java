package fr.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.sopra.dao.IDAOCombat;
import fr.sopra.dao.IDAOCoup;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;

@Controller
@RequestMapping("/combat")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CombatController {

	@Autowired
	IDAOCombat daoCombat;

	@Autowired
	IDAOCoup daoCoup;
	
	@ModelAttribute("combat")
	public Combat initCombat() {
		return new Combat();
	}
	
	@GetMapping("/read")
	public String getCombats(Model model) {
		List<Combat> combats = daoCombat.findAll();
		model.addAttribute("combats", combats);
		return "combats";
	}
	
	
	
	//COUPS
	@GetMapping("/coup")
	public String getCoups(@ModelAttribute("combat") Combat combat, Model model) {
		List<Coup> coups = daoCoup.findByCombat(combat);
		model.addAttribute("coups", coups);
		return "coups";
	}
}