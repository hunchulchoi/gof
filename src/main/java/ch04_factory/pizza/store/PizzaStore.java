package ch04_factory.pizza.store;

import ch04_factory.pizza.factory.SimplePizzaFactory;
import ch04_factory.pizza.pizza.Pizza;

public class PizzaStore {

  SimplePizzaFactory factory;

  public PizzaStore(SimplePizzaFactory factory) {
    this.factory = factory;
  }

  public Pizza orderPizza(String type){

    Pizza pizza = factory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
