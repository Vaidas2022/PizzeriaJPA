package javau9.pizzeria.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import javau9.pizzeria.models.Pizza;

@Service
public class PizzaServiceImpl implements PizzaService{

    private final Map<Long, Pizza> pizzaDatabase = new HashMap<>();
    
    
    public PizzaServiceImpl() {
    	addPizza(new Pizza(1L, "Margarita", 	"20 cm", 7.99d));
    	addPizza(new Pizza(2L, "Pepperoni", 	"25 cm", 8.99d));
    	addPizza(new Pizza(3L, "Hawaiian", 		"30 cm", 9.49d));
    	addPizza(new Pizza(4L, "BBQ Chicken", 	"20 cm", 10.99d));
    	addPizza(new Pizza(5L, "Veggie", 		"25 cm", 8.49d));
    	addPizza(new Pizza(6L, "Meat Feast", 	"30 cm", 11.99d));
    	addPizza(new Pizza(7L, "Buffalo", 		"20 cm", 9.99d));
    	addPizza(new Pizza(8L, "Seafood", 		"25 cm", 12.99d));
    	addPizza(new Pizza(9L, "Four Cheese", 	"30 cm", 8.99d));
    	addPizza(new Pizza(10L, "Mexican", 		"20 cm", 10.49d));
    	addPizza(new Pizza(11L, "Greek", 		"25 cm", 9.49d));
    }

    public void addPizza(Pizza pizza) {
        pizzaDatabase.put(pizza.getId(), pizza);
    }

    public Pizza getPizzaById(Long id) {
        return pizzaDatabase.get(id);
    }

    public Collection<Pizza> getAllPizzas() {
        return pizzaDatabase.values();
    }

    public void removePizza(Long id) {
        pizzaDatabase.remove(id);
    }
}