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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javau9.pizzeria.models.Pizza;
import javau9.pizzeria.services.PizzaService;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
    PizzaService pizzaService;


    @GetMapping("/all")
    public Collection<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
    	return ResponseEntity.of( pizzaService.getPizzaById(id) );

    }
    
    @PostMapping("/add")
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
        Pizza savedPizza = pizzaService.addPizza(pizza);
        return ResponseEntity.ok(savedPizza);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza pizza ) {
    	return ResponseEntity.of( pizzaService.updatePizza(id, pizza) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePizza(@PathVariable Long id) {
        return pizzaService.deletePizza(id) ?
            ResponseEntity.ok().build() : // Grąžinamas 200 OK, jei pica sėkmingai ištrinta
            ResponseEntity.notFound().build(); // Grąžinamas 404 Not Found, jei pica nerasta
    }
    
}
