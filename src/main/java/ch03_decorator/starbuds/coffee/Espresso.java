package ch03_decorator.starbuds.coffee;

import ch03_decorator.starbuds.beverage.Beverage;

public class Espresso extends Beverage {

  public Espresso() {
    this.description = "에스프레소";
  }

  public Espresso(int shot){
    this();
    this.shot = shot;
  }

  public Espresso(Size size) {
    this();
    this.size = size;
  }

  public Espresso(int shot, Size size) {
    this();
    this.shot = shot;
    this.size = size;
  }

  @Override
  protected double price() {
    return switch (this.size){
      case TALL -> 1.99;
      case GRANDE -> 2.99;
      case VENTI -> 3.99;
    };
  }
}
