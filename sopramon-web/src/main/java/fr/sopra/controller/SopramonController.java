package fr.sopra.controller;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.idao.IDAOCapacite;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Sopramon;


@Controller
public class SopramonController {
	@Autowired
	private IDAOSopramon daoSopramon;
	 
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	 
	
	@Autowired
	private IDAOCapacite daoCapacite;
	/*OK*/
	@GetMapping("/sopramon")
	public String findAll(Model model) {
		model.addAttribute("sopramons", daoSopramon.findAll());
		return "sopramon";
	}
	
	
//	@GetMapping("/createSopramon")
//	public String createSopramon(Model model) {
//		model.addAttribute("gammes", daoGamme.findAll());
//		return "form-sopramon";
//	}
	
	
	@PostMapping("/createSopramon")
	public String createSopramon(@ModelAttribute Sopramon sopramon) {
		daoSopramon.save(sopramon);
		return "redirect:sopramon";
	}
	
	@GetMapping("/createSop")
	public String createSopramon(Model model) {
		List<Capacite> capacites = daoCapacite.findAll();
		model.addAttribute("capacites", capacites);
	
		return "createSopramon";
	}
	
	@PostMapping({ "/createSop" })
	public String createSopramon(@RequestParam String nom, @RequestParam int niveau, @RequestParam Signe signe, 
								 @RequestParam int pv, @RequestParam int attaque,@RequestParam int defense, 
								 @RequestParam int esquive, @RequestParam int vitesse) {
		
		Sopramon mySopramon = new Sopramon();
		Capacite myCapacite = new Capacite();

		mySopramon.setNom(nom);
		mySopramon.setNiveau(niveau);
		mySopramon.setSigne(signe);
		mySopramon.setCapacite(myCapacite);
		
		myCapacite.setPointsDeVie(pv);
		myCapacite.setAttaque(attaque);
		myCapacite.setDefense(defense);
		myCapacite.setVitesse(vitesse);
		myCapacite.setEsquive(esquive);
		
		daoSopramon.save(mySopramon);

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
		return "createSopramon";
	}
	

	@GetMapping("/bannirSopramon")
	public String bannirSopramon(@RequestParam int access, Model model) {
		
		if (access == 0) {access = 1;} else {access = 0;}
		
		return "redirect:sopramon";
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
