package fr.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.sopra.idao.IDAOCombat;
import fr.sopra.model.game.Combat;

@Controller
@RequestMapping("/combat")
public class CombatController {

	@Autowired
	IDAOCombat daoCombat;

	
	@ModelAttribute("combat")
	public Combat initCombat() {
		return new Combat();
	}
	
	@GetMapping("/read")
	public String getItems(Model model) {
		List<Combat> combats = daoCombat.findAll();
		model.addAttribute("combats", combats);
		return "combats";
	}
}