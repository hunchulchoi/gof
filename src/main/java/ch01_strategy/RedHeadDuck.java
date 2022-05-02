package ch01_strategy;

import ch01_strategy.behavior.FlyWithWings;
import ch01_strategy.behavior.Quack;

public class RedHeadDuck extends Duck{

  public RedHeadDuck() {
    super(new Quack(), new FlyWithWings());
  }

  @Override
  String display() {
    return "Am ReadHeadDuck";
  }
}
