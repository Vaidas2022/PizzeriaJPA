package javau9.pizzeria.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
    	return ResponseEntity.of( pizzaService.getPizzaById(id) );

    }
    
    @PostMapping("/pizzas/add")
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
        Pizza savedPizza = pizzaService.addPizza(pizza);
        return ResponseEntity.ok(savedPizza);
    }
    
    @PutMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza pizza ) {
    	return ResponseEntity.of( pizzaService.updatePizza(id, pizza) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        boolean isDeleted = pizzaService.deletePizza(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    
}
