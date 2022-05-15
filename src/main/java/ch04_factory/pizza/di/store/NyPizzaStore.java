package ch04_factory.pizza.di.store;

import ch04_factory.pizza.di.ingredient.NyPizzaIngredientFactory;
import ch04_factory.pizza.di.ingredient.PizzaIngredientFactory;
import ch04_factory.pizza.di.pizza.CheesePizza;
import ch04_factory.pizza.di.pizza.Pizza;

public class NyPizzaStore extends PizzaStore{
  @Override
  public Pizza createPizza(String item) {

    PizzaIngredientFactory pizzaIngredientFactory = new NyPizzaIngredientFactory();

    return switch (item){
      case "cheese"-> new CheesePizza(pizzaIngredientFactory, "뉴욕 스타일 치즈 피자");
      default -> throw new UnsupportedOperationException("알수없는 피자->" + item);
    };
  }
}
