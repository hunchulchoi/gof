package ch01_strategy;

import ch01_strategy.behavior.FlyBehavior;
import ch01_strategy.behavior.FlyNoWay;
import ch01_strategy.behavior.MuteQuack;
import ch01_strategy.behavior.QuackBehavior;

public class DecoyDuck extends Duck{

  public DecoyDuck() {
    super(new MuteQuack(), new FlyNoWay());
  }

  @Override
  String display() {
    return "I'm DecoyDuck";
  }
}
