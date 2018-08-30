package fr.sopra.controller;

import java.util.List;

@RequestMapping("/item")
public class ItemController {

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
	public String createItemPost(@RequestParam String nom, @RequestParam float prix, @RequestParam int gamme, 
			Model model) {
		
		Item myItem = new Item();
		Capacite myCapacite = new Capacite();
	
		myCapacite.setId(gamme);
		myItem.setNom(nom);
		myItem.setPrix(prix);
		
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
