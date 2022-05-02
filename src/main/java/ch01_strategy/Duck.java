package ch01_strategy;

import ch01_strategy.behavior.FlyBehavior;
import ch01_strategy.behavior.QuackBehavior;
import lombok.Setter;


public abstract class Duck {

  @Setter
  private QuackBehavior quackBehavior;
  @Setter
  private FlyBehavior flyBehavior;

  public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
    this.quackBehavior = quackBehavior;
    this.flyBehavior = flyBehavior;
  }

  String perfumeQuack(){
    return this.quackBehavior.quack();
  }
  String swim(){
    return "swim";
  }
  String perfumeFly(){
    return this.flyBehavior.fly();
  }
  abstract String display();
}
