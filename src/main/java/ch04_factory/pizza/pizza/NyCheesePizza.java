package ch04_factory.pizza.pizza;

public class NyCheesePizza extends Pizza {

  private final String name = "Cheese pizza NY style";

  @Override
  public void prepare() {
    System.out.println(name + " ->prepare");
  }

  @Override
  public void bake() {
    System.out.println(name + " ->bake");
  }

  @Override
  public void cut() {
    System.out.println(name + " ->cut");
  }

  @Override
  public void box() {
    System.out.println(name + " ->box");
  }
}
