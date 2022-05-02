package ch01_strategy.behavior;

public class Quack implements QuackBehavior{
  @Override
  public String quack() {
    return "quack quack";
  }
}
