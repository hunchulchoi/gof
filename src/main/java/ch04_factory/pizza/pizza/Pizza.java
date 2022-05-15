package ch04_factory.pizza.pizza;

import lombok.Getter;

public abstract class Pizza {

  @Getter
  protected String name;

  public abstract void prepare();
  public abstract void bake();
  public abstract void cut();
  public abstract void box();
}
