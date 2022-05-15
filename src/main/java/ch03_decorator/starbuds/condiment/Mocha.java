package ch03_decorator.starbuds.condiment;

import ch03_decorator.starbuds.beverage.Beverage;
import ch03_decorator.starbuds.beverage.CondimentDecorator;

public class Mocha extends CondimentDecorator {

  public Mocha(Beverage beverage) {
    this.description = "모카";
    this.beverage = beverage;
  }

  public Mocha(Beverage beverage, int shot) {
    this(beverage);
    this.shot = shot;
  }

  @Override
  protected double price() {

    return switch (getSize()){
      case TALL -> 0.3;
      case GRANDE -> 0.35;
      case VENTI -> 0.4;
    };
  }
}
