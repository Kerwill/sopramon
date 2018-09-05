package fr.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.sopra.dao.IDAOAchat;
import fr.sopra.model.game.Achat;

@Controller
@RequestMapping("/achat")
public class AchatController {

	@Autowired
	IDAOAchat daoAchat;

	
	@ModelAttribute("achat")
	public Achat initAchat() {
		return new Achat();
	}
	
	@GetMapping("/read")
	public String getItems(Model model) {
		List<Achat> achats = daoAchat.findAll();
		model.addAttribute("achats", achats);
		return "achats";
	}
}