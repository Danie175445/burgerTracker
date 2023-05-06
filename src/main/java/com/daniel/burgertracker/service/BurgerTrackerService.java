package com.daniel.burgertracker.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.burgertracker.models.BurgerTrackerModel;
import com.daniel.burgertracker.repository.BurgerTrackerRepository;

@Service
public class BurgerTrackerService {
	@Autowired
	BurgerTrackerRepository burgerRepository;
	
	public ArrayList<BurgerTrackerModel> allBurgers(){
		return	burgerRepository.findAll();
	}
	
	public BurgerTrackerModel createBurger (BurgerTrackerModel burger) {
		return burgerRepository.save(burger);
	}
	
	
}
