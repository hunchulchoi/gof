package ch04_factory.pizza.di.pizza;

import ch04_factory.pizza.di.ingredient.PizzaIngredientFactory;

public class CheesePizza extends Pizza{

  public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory, String name) {
    super(pizzaIngredientFactory, name);
  }
}
