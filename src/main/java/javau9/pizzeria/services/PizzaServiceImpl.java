package javau9.pizzeria.services;

import java.util.Collection;
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

    public Optional<Pizza> getPizzaById(Long id) {
    	System.out.println( "-----> " + id );
        return pizzaDatabase.findById(id);
    }

    public Collection<Pizza> getAllPizzas() {
        return pizzaDatabase.findAll();
    }

    public void removePizza(Long id) {
        pizzaDatabase.deleteById(id);
    }

	@Override
	public Optional<Pizza> updatePizza(Long id, Pizza pizza) {
		return Optional.of(  pizzaDatabase.save(pizza) );
	}
}