package ch01_strategy.behavior;

public class FlyWithWings implements FlyBehavior{

  @Override
  public String fly(){
    return "flying....";
  }
}
