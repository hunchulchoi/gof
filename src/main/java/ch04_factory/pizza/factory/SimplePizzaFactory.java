package ch04_factory.pizza.factory;

import ch04_factory.pizza.pizza.CheesePizza;
import ch04_factory.pizza.pizza.PepperoniPizza;
import ch04_factory.pizza.pizza.Pizza;

public class SimplePizzaFactory {
  public Pizza createPizza(String type) {
    return switch (type){
      case "cheese"-> new CheesePizza();
      case "peperoni"-> new PepperoniPizza();
      default -> throw new UnsupportedOperationException("알수없는 타입->" + type);
    };
  }
}
