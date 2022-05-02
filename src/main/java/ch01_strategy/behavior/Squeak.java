package ch01_strategy.behavior;

public class Squeak implements QuackBehavior{
  @Override
  public String quack() {
    return "Beep Beep";
  }
}
