package com.daniel.burgertracker.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daniel.burgertracker.models.BurgerTrackerModel;
import com.daniel.burgertracker.service.BurgerTrackerService;

import jakarta.validation.Valid;

@Controller
public class BurgerTrackerController {
	
	@Autowired
	BurgerTrackerService burgerService;
	
	@GetMapping("/home")
	public String index(@ModelAttribute("burger")BurgerTrackerModel burgerTrackerModel,Model model) {
		ArrayList<BurgerTrackerModel>burgers = burgerService.allBurgers();
		model.addAttribute("burgers",burgers);
		return "index.jsp";
	}
	
	@PostMapping("/burger")
	public String create(@Valid @ModelAttribute("burger")BurgerTrackerModel burgerTrackerModel, BindingResult result,Model model) {
		if(result.hasErrors()) {
			ArrayList<BurgerTrackerModel>burgers = burgerService.allBurgers();
			model.addAttribute("burgers",burgers);
			return "index.jsp";
		}
		burgerService.createBurger(burgerTrackerModel);
		return "redirect:/home";
	}
	
}
