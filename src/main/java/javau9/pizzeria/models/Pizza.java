package javau9.pizzeria.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    private String size;
    private double price;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "pizza_ingredient",
        joinColumns = @JoinColumn(name = "pizza_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    List<Ingredient> ingredients = new ArrayList<>();
    
    public Pizza() {}
    
    public Pizza(Long id, String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
    
    public Pizza(String name) {
        this.name = name;
    }
    
    public Pizza addIngredient(Ingredient ingridient) {
    	ingridient.addPizza(this);
    	ingredients.add(ingridient);
    	return this;
    }
    
    public List<Ingredient> getIngredients(){
    	return ingredients;
    }

    // Getteriai ir Setteriai
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
