package ch04_factory.pizza.di.ingredient;

public class NyPizzaIngredientFactory implements PizzaIngredientFactory{

  @Override
  public Ingredient.Dough createDough() {
    return Ingredient.Dough.ThinCrustDough;
  }

  @Override
  public Ingredient.Sauce createSauce() {
    return Ingredient.Sauce.TomatoSauce;
  }

  @Override
  public Ingredient.Cheese createCheese() {
    return Ingredient.Cheese.GoatCheese;
  }

  @Override
  public Ingredient.Veggies[] createVeggies() {
    return new Ingredient.Veggies[]{Ingredient.Veggies.Garlic, Ingredient.Veggies.Onion, Ingredient.Veggies.Mushroom};
  }
}
