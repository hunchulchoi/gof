package ch03_decorator.starbuds.condiment;

import ch03_decorator.starbuds.beverage.Beverage;
import ch03_decorator.starbuds.beverage.CondimentDecorator;

public class SoyMilk extends CondimentDecorator {


  public SoyMilk(Beverage beverage) {
    this.beverage = beverage;
    this.description = "두유";
  }
  public SoyMilk(Beverage beverage, int shot){
    this(beverage);
    this.shot = shot;
  }

  @Override
  protected double price() {
    return switch (getSize()){
      case TALL -> 0.2;
      case GRANDE -> 0.25;
      case VENTI -> 0.28;
    };
  }
}
