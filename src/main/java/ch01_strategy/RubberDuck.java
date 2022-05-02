package ch01_strategy;

import ch01_strategy.behavior.FlyBehavior;
import ch01_strategy.behavior.FlyNoWay;
import ch01_strategy.behavior.QuackBehavior;
import ch01_strategy.behavior.Squeak;

public class RubberDuck extends Duck{

  public RubberDuck() {
    super(new Squeak(), new FlyNoWay());
  }

  @Override
  String display() {
    return "I'm RubberDuck I'm toy";
  }

}
