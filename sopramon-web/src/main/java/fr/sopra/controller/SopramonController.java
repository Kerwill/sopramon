package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Sopramon;


@Controller
public class SopramonController {
	@Autowired
	private IDAOSopramon daoSopramon;
	 
	
	@GetMapping("/sopramon")
	public String findAll(Model model) {
		model.addAttribute("sopramons", daoSopramon.findAll());
		return "sopramon";
	}
	
	
//	@GetMapping("/ajouterSopramon")
//	public String ajouterSopramon(Model model) {
//		model.addAttribute("gammes", daoGamme.findAll());
//		return "form-sopramon";
//	}
	
	
	@PostMapping("/ajouterSopramon")
	public String ajouterSopramon(@ModelAttribute Sopramon sopramon) {
		daoSopramon.save(sopramon);
		return "redirect:sopramon";
	}
	
	
	@GetMapping("/supprimerSopramon")
	public String supprimerSopramon(@RequestParam int id) {
		daoSopramon.deleteById(id);
		return "redirect:sopramon";
	}
	
		
	@GetMapping("/editerSopramon")
	public String editerSopramon(@RequestParam int id, Model model) {
		model.addAttribute("sopramon", daoSopramon.findById(id).get());
		return "form-sopramon";
	}
	
	
	@GetMapping("/bannirSopramon")
	public String bannirSopramon(@RequestParam int id, Model model) {
		model.addAttribute("sopramon", daoSopramon.findById(id).get());
		return "form-sopramon";
	}
	
//	@PostMapping("/editerSopramon")
//	public String editerSopramon(@ModelAttribute Sopramon sopramon) {
//		Capacite myCapacite = new Capacite();
//		
//		myCapacite.setId(1);
//		sopramon.setCapacite(myCapacite);
//		
//		daoSopramon.save(sopramon);
//		return "redirect:sopramon";
//	}
}
