package ch04_factory.pizza.store;

import ch04_factory.pizza.pizza.NyCheesePizza;
import ch04_factory.pizza.pizza.NyPepperoniPizza;
import ch04_factory.pizza.pizza.Pizza;

public class NyPizzaStore extends AbPizzaStore{

  @Override
  protected Pizza createPizza(String type) {
    return switch (type){
      case "cheese"-> new NyCheesePizza();
      case "pepperoni"-> new NyPepperoniPizza();
      default -> throw new UnsupportedOperationException("알수없는 타입->" + type);
    };
  }
}
