package com.daniel.burgertracker.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.burgertracker.models.BurgerTrackerModel;

@Repository
public interface BurgerTrackerRepository extends CrudRepository<BurgerTrackerModel, Long> {
	ArrayList<BurgerTrackerModel> findAll();
}
