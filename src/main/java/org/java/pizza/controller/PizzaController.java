package org.java.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Pizza;
import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/")
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

	@PostMapping("/pizza/by/name")
	public String getPizzaByName(Model model, @RequestParam(required = false) String name) {

		List<Pizza> pizzas = pizzaService.findByNome(name);
		System.out.println(pizzas);
		model.addAttribute("pizzas", pizzas);
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "create";

	}

	@PostMapping("/create")
	public String store(@ModelAttribute("pizza") Pizza formPizza, Model model) {
		pizzaService.save(formPizza);
		return "redirect:/";
	}

}
