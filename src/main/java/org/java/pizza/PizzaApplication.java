package org.java.pizza;

import java.util.ArrayList;
import java.util.List;

import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaApplication implements CommandLineRunner {
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Pizza val : this.getPizzas()) {
			pizzaService.save(val);
		}

	}

	public List<Pizza> getPizzas() {
		List<Pizza> pizzas = new ArrayList<>();

		pizzas.add(new Pizza("Americana", "Pomodoro, Mozzarella, Wurstel",
				"https://external-preview.redd.it/bnDRcRxxhrKkypxeiM8zlAn7J1nfeo-YnIIE2uPAAOY.jpg?width=640&crop=smart&auto=webp&s=cb80465e46dac28e4b2adb8ba652371376b600b2",
				2.5));
		pizzas.add(new Pizza("Margherita", "Pomodoro, Mozzarella, Patatine",
				"https://www.lemilleeunabontadifranci.it/wp-content/uploads/2021/04/Pizza-margherita-fatta-in-casa-orizzontale.jpg",
				1.50));
		pizzas.add(new Pizza("Napoli", "Pomodoro, Mozzarella, Acciughe, Capperi",
				"https://www.donnamoderna.com/content/uploads/2021/08/pizza-napoli-830x625.jpg", 1.50));
		pizzas.add(new Pizza("4 Stagioni", "Pomodoro, Mozzarella, Carciofi, Olive, Cotto, Funghi",
				"https://cdn.cook.stbm.it/thumbnails/ricette/144/144880/hd750x421.jpg", 1.50));
		pizzas.add(new Pizza("Salame Piccante", "Pomodoro, Mozzarella, Salame Piccante",
				"https://media.istockphoto.com/id/1142744772/it/foto/pizza-pepperoni-su-sfondo-di-cemento-nero.jpg?s=612x612&w=0&k=20&c=4OHrtlThkiICrHd9JSbhG1E52U-GS7am1VI_ts106_0=",
				1.50));
		return pizzas;
	}

}
