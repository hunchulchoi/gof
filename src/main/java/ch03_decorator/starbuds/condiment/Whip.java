package ch03_decorator.starbuds.condiment;

import ch03_decorator.starbuds.beverage.Beverage;
import ch03_decorator.starbuds.beverage.CondimentDecorator;

public class Whip extends CondimentDecorator {
  public Whip(Beverage beverage) {
    this.description = "휘핑크림";
    this.beverage = beverage;
  }
  public Whip(Beverage beverage, int shot){
    this(beverage);
    this.shot = shot;
  }

  @Override
  protected double price() {
    return switch (getSize()){
      case TALL -> 0.3;
      case GRANDE -> 0.33;
      case VENTI -> 0.5;
    };
  }
}
