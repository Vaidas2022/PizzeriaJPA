package javau9.pizzeria.services;

import java.util.Collection;


import javau9.pizzeria.models.Pizza;

public interface PizzaService {

    void addPizza(Pizza pizza);

    Pizza getPizzaById(Long id);

    Collection<Pizza> getAllPizzas();

    void removePizza(Long id);
}
