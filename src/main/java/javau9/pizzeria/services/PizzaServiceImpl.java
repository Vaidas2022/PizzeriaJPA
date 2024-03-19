package javau9.pizzeria.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javau9.pizzeria.repositories.PizzaRepository;
import javau9.pizzeria.models.Pizza;

@Service
public class PizzaServiceImpl implements PizzaService {

	PizzaRepository pizzaDatabase;

	public PizzaServiceImpl(PizzaRepository pizzaDatabase) {
		this.pizzaDatabase = pizzaDatabase;
	}

	@Override
	public Pizza addPizza(Pizza pizza) {
		return pizzaDatabase.save(pizza);
	}

	@Override
	public Optional<Pizza> getPizzaById(Long id) {
		System.out.println("-----> " + id);
		return pizzaDatabase.findById(id);
	}

	@Override
	public Collection<Pizza> getAllPizzas() {
		return pizzaDatabase.findAll();
	}

	@Override
	public void removePizza(Long id) {
		pizzaDatabase.deleteById(id);
	}

	@Override
	public Optional<Pizza> updatePizza(Long id, Pizza pizza) {
		
		Optional<Pizza> existingPizza = pizzaDatabase.findById(id);
		if (existingPizza.isEmpty())
			return Optional.empty();

		Pizza updatedPizza = existingPizza.get();
		updatedPizza.setName(	pizza.getName() );
		updatedPizza.setSize(	pizza.getSize() );
		updatedPizza.setPrice(	pizza.getPrice() );

		return Optional.of(pizzaDatabase.save(updatedPizza));

	}

	@Override
    public boolean deletePizza(Long id) {
        if (pizzaDatabase.existsById(id)) {
        	pizzaDatabase.deleteById(id);
            return true;
        }
        return false;
    }
	
	
}