package fr.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")

	public String getHome() {
		return "home";
	}

	
	@RequestMapping("/admin")

	public String getAdmin() {
		return "admin";
	}
	
	 @GetMapping("/logout")
	    public String logout(Model model) {
	        return "logout";
	    }
}
