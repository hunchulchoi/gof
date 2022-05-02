package ch01_strategy;

import ch01_strategy.behavior.Quack;
import ch01_strategy.behavior.QuackBehavior;

public class DuckCaller {

  private QuackBehavior quackBehavior;

  public DuckCaller(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }

  public void perfumeQuack(){
    System.out.println(quackBehavior.quack());
    System.out.println(quackBehavior.quack());
  }

  public static void main(String[] args) {
    DuckCaller duckCaller = new DuckCaller(new Quack());
    duckCaller.perfumeQuack();
  }
}
