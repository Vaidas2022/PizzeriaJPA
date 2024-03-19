package javau9.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javau9.pizzeria.models.Ingredient;
import javau9.pizzeria.models.Pizza;
import javau9.pizzeria.services.PizzaService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
    PizzaService pizzaService;

	@GetMapping("/dummy")
	public Pizza getDummyPizza() {
		Pizza pizza = new Pizza("Dummy");
		
		Ingredient padas = new Ingredient("Storas padas", "Amerikietisko stiliaus", 4.80);
		Ingredient suris = new Ingredient("Mocarella", "Super sviezias baltas minkstas", 1.80);
		Ingredient pomidorai = new Ingredient("Pomidorai", "Sauleje prinoke pomidorai", 0.70);
		
		pizza
			.addIngredient(padas)
			.addIngredient(suris)
			.addIngredient(pomidorai);
		
		pizzaService.addPizza(pizza);
		
		return pizza;
		
	}
	
	
	
}
