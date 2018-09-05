package fr.sopra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOCapacite;
import fr.sopra.dao.IDAOItem;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Item;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	IDAOItem daoItem;
	
	@Autowired
	IDAOCapacite daoCapacite;
	
	@ModelAttribute("item")
	public Item initItem() {
		return new Item();
	}
	
	@GetMapping("/read")
	public String getItems(Model model) {
		List<Item> items = daoItem.findAll();
		model.addAttribute("items", items);
		return "items";
	}

	@GetMapping({ "/create" })
	public String createItemGet() {
		
		return "createItem";
	}

	@PostMapping({ "/create" })
	public String createItemPost(@Valid @ModelAttribute("item") Item item, BindingResult result, Model model)  {
		
		
		if (result.hasErrors()) {
			return "createItem";
		}
		
		daoItem.save(item);

		return "redirect:/item/read";
	}

	@GetMapping({ "/delete" })
	public String deleteItemGet(@RequestParam int id, Model model) {

		daoItem.deleteById(id);

		return "redirect:/item/read";
	}


	@GetMapping("/update")
	public String updateItemGet(@RequestParam int id, Model model) {

		model.addAttribute("item", daoItem.findById(id).get());

		return "createItem";
	}
	
	@PostMapping({ "/update" })
	public String updateItemPost (@Valid @ModelAttribute("item") Item item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "createItem";
		}
		
		daoItem.save(item);

		return "redirect:/item/read";
	}
}



//(@RequestParam String nom, @RequestParam float prix, @RequestParam int pointsDeVie, @RequestParam int attaque, @RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse,
//		Model model)