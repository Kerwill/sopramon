package fr.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.idao.IDAOCapacite;
import fr.sopra.idao.IDAOItem;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Item;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	IDAOItem daoItem;
	
	@Autowired
	IDAOCapacite daoCapacite;
	
	@GetMapping("/read")
	public String getItems(Model model) {
		List<Item> items = daoItem.findAll();
		model.addAttribute("items", items);
		return "items";
	}

	@GetMapping({ "/create" })
	public String createItemGet(Model model) {
		List<Capacite> capacites = daoCapacite.findAll();
		model.addAttribute("capacites", capacites);

		return "createItem";
	}

	@PostMapping({ "/create" })
	public String createItemPost(@RequestParam String nom, @RequestParam float prix, @RequestParam int pv, @RequestParam int att, @RequestParam int def, @RequestParam int esq, @RequestParam int vit,
			Model model) {
		
		Item myItem = new Item();
		Capacite myCapacite = new Capacite();
	
		myItem.setNom(nom);
		myItem.setPrix(prix);
		
		myCapacite.setPointsDeVie(pv);
		myCapacite.setAttaque(att);
		myCapacite.setDefense(def);
		myCapacite.setVitesse(vit);
		myCapacite.setEsquive(esq);
		myItem.setCapacite(myCapacite);
		
		daoItem.save(myItem);

		return "redirect:http://localhost:8080/sopramon-web/item/read";
	}

	@GetMapping({ "/delete" })
	public String deleteItemGet(@RequestParam int id, Model model) {

		daoItem.deleteById(id);

		return "redirect:http://localhost:8080/sopramon-web/item/read";
	}

	@GetMapping("/update")
	public String updateItemGet(@RequestParam int id, Model model) {
		List<Capacite> capacites = daoCapacite.findAll();
		model.addAttribute("capacites", capacites);
		model.addAttribute("produit", daoItem.findById(id).get());

		return "createItem";
	}

	@PostMapping({ "/update" })
	public String updateItemPost(@RequestParam int id, @RequestParam String nom, @RequestParam float prix, @RequestParam int gamme,
			Model model) {

		Item myItem = new Item();
		Capacite myCapacite = new Capacite();

		myCapacite.setId(gamme);
		
		myItem.setId(id);
		myItem.setNom(nom);
		myItem.setPrix(prix);
		myItem.setCapacite(myCapacite);

		daoItem.save(myItem);

		return "redirect:http://localhost:8080/sopramon-web/item/read";
	}
}