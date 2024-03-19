package javau9.pizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javau9.pizzeria.models.Ingredient;

@Repository
public interface IngridientRepository extends JpaRepository<Ingredient, Long> {

}
