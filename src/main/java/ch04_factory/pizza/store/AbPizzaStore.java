package ch04_factory.pizza.store;

import ch04_factory.pizza.pizza.Pizza;

public abstract class AbPizzaStore {

  public Pizza orderPizza(String type){

    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}
