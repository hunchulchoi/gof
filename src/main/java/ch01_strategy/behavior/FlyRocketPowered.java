package ch01_strategy.behavior;

public class FlyRocketPowered implements FlyBehavior{

  @Override
  public String fly() {
    return "Shhhhhhhhhhhhhhhhhhhhhhh * 100 faster";
  }
}
