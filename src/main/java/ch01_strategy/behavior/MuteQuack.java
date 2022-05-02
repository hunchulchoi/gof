package ch01_strategy.behavior;

public class MuteQuack implements QuackBehavior{

  @Override
  public String quack() {
    return null;
  }
}
