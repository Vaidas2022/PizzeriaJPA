package javau9.pizzeria.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javau9.pizzeria.models.Pizza;
import javau9.pizzeria.services.PizzaService;

@RestController
public class PizzaController {

	@Autowired
    PizzaService pizzaService;


    @GetMapping("/pizzas")
    public Collection<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }


    @GetMapping("/pizzas/{id}")
    public Pizza getPizzaById(@PathVariable Long id) {
        return pizzaService.getPizzaById(id);
    }
}
