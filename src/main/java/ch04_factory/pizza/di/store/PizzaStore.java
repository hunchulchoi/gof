package ch04_factory.pizza.di.store;

import ch04_factory.pizza.di.ingredient.PizzaIngredientFactory;
import ch04_factory.pizza.di.pizza.Pizza;

public abstract class PizzaStore {

  public Pizza orderPizza(String type){
    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  public abstract Pizza createPizza(String item);

}
