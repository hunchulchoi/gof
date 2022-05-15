package ch04_factory.pizza.store;

import ch04_factory.pizza.pizza.ChicagoCheesePizza;
import ch04_factory.pizza.pizza.NyCheesePizza;
import ch04_factory.pizza.pizza.NyPepperoniPizza;
import ch04_factory.pizza.pizza.Pizza;

public class ChicagoPizzaStore extends AbPizzaStore{

  @Override
  protected Pizza createPizza(String type) {
    return switch (type){
      case "cheese"-> new ChicagoCheesePizza();
      default -> throw new UnsupportedOperationException("알수없는 타입->" + type);
    };
  }
}
