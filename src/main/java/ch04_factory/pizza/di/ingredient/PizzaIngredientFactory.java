package ch04_factory.pizza.di.ingredient;

public interface PizzaIngredientFactory {

  public Ingredient.Dough createDough();
  public Ingredient.Sauce createSauce();
  public Ingredient.Cheese createCheese();
  public Ingredient.Veggies[] createVeggies();
}
