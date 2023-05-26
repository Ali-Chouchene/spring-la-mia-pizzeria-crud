package org.java.pizza.serv;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Pizza;
import org.java.pizza.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepo repo;

	public List<Pizza> findAll() {
		return (List<Pizza>) repo.findAll();
	}

	public Pizza save(Pizza pizza) {
		return repo.save(pizza);
	}

	public Optional<Pizza> findById(int id) {
		return repo.findById(id);
	}
}
