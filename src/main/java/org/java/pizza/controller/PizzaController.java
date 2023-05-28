package org.java.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Pizza;
import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/pizza")
	public String pizzas(Model model) {

		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		return "index";

	}

	@GetMapping("/pizza/{id}")
	public String pizzaId(Model model, @PathVariable("id") int id) {
		Optional<Pizza> pizzaId = pizzaService.findById(id);
		Pizza pizza = pizzaId.get();
		model.addAttribute("pizza", pizza);
		return "single";

	}

}
