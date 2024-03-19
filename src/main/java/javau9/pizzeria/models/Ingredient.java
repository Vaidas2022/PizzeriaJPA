package javau9.pizzeria.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY )
	Long id;
	
	String name;
	String description;
	Double price;
	
	
	@ManyToMany(mappedBy = "ingredients")
	List<Pizza> pizzas = new ArrayList<>();
	
	
	
	public Ingredient() {}

	public Ingredient(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + " - " + description + " " + price ;
	}
	
	
	
}
