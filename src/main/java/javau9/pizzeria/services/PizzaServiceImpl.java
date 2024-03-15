package javau9.pizzeria.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javau9.pizzeria.repositories.PizzaRepository;
import javau9.pizzeria.models.Pizza;

@Service
public class PizzaServiceImpl implements PizzaService{

    PizzaRepository pizzaDatabase;
    
    public PizzaServiceImpl(PizzaRepository pizzaDatabase) {
    	this.pizzaDatabase = pizzaDatabase;
    }
       
    public Pizza addPizza(Pizza pizza) {
        return pizzaDatabase.save(pizza);
    }

    public Pizza getPizzaById(Long id) {
        return pizzaDatabase.findById(id).get();
    }

    public Collection<Pizza> getAllPizzas() {
        return pizzaDatabase.findAll();
    }

    public void removePizza(Long id) {
        pizzaDatabase.deleteById(id);
    }
}