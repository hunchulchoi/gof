package ch01_strategy;

import ch01_strategy.behavior.FlyWithWings;
import ch01_strategy.behavior.Quack;

public class ModelDuck extends Duck{

  public ModelDuck() {
    super(new Quack(), new FlyWithWings());
  }

  @Override
  String display() {
    return "Am ModelDuck";
  }
}
