package ch04_factory.pizza.factory;

import ch04_factory.pizza.pizza.NyCheesePizza;
import ch04_factory.pizza.pizza.Pizza;

public class NyPizzaFactory extends SimplePizzaFactory{
  @Override
  public Pizza createPizza(String type) {
    return switch (type){
      case "cheese"-> new NyCheesePizza();
      default -> super.createPizza(type);
    };
  }
}
