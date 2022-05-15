package ch04_factory.pizza.di.pizza;

import ch04_factory.pizza.di.ingredient.Ingredient;
import ch04_factory.pizza.di.ingredient.PizzaIngredientFactory;
import lombok.Getter;

import java.util.Arrays;

public abstract class Pizza {

  protected PizzaIngredientFactory pizzaIngredientFactory;

  @Getter
  protected String name;

  protected Ingredient.Dough dough;
  protected Ingredient.Sauce sauce;
  protected Ingredient.Cheese cheese;
  protected Ingredient.Veggies[] veggies;

  public Pizza(PizzaIngredientFactory pizzaIngredientFactory, String name) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
    this.name = name;
  }

  public void prepare(){
    this.dough = pizzaIngredientFactory.createDough();
    this.sauce = pizzaIngredientFactory.createSauce();
    this.cheese = pizzaIngredientFactory.createCheese();
    this.veggies = pizzaIngredientFactory.createVeggies();
  }

  public void bake(){
    System.out.println("175도에서 25분간 굽기");
  }

  public void cut(){
    System.out.println("피자를 사선으로 자르기");
  }

  public void box(){
    System.out.println("상자에 피자를 담기");
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "name='" + name + '\'' +
        ", dough=" + dough +
        ", sauce=" + sauce +
        ", cheese=" + cheese +
        ", veggies=" + Arrays.toString(veggies) +
        '}';
  }
}
