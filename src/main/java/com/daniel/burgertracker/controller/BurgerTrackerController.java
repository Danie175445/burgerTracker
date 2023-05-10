package com.daniel.burgertracker.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@GetMapping("/edit/burger/{id}")
	public String edit(@PathVariable("id") Long id,Model model) {
		BurgerTrackerModel burgers = burgerService.findBurger(id);
		model.addAttribute("burgers",burgers);
				return "edit.jsp";
	}
	@RequestMapping(value="/burger/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("burgers")BurgerTrackerModel burgerTrackerModel, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burgers", burgerTrackerModel);
			return "edit.jsp";
		}
		else {
			burgerService.updateBurger(burgerTrackerModel);
			return "redirect:/home";
			
		}
	}
	
	
}
