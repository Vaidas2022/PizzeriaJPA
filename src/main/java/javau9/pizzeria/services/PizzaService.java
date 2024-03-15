package javau9.pizzeria.services;

import java.util.Collection;
import java.util.Optional;

import javau9.pizzeria.models.Pizza;

public interface PizzaService {

    Pizza addPizza(Pizza pizza);

    Optional<Pizza> getPizzaById(Long id);

    Collection<Pizza> getAllPizzas();

    void removePizza(Long id);

	Optional<Pizza> updatePizza(Long id, Pizza pizza);

	boolean deletePizza(Long id);
}
