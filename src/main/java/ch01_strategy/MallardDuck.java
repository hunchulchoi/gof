package ch01_strategy;

import ch01_strategy.behavior.FlyWithWings;
import ch01_strategy.behavior.Quack;

public class MallardDuck extends Duck{

  public MallardDuck() {
    super(new Quack(), new FlyWithWings());
  }

  @Override
  public String display() {
    return "I'm Mallard duck";
  }
}
