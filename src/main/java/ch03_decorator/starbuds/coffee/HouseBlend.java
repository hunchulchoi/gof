package ch03_decorator.starbuds.coffee;

import ch03_decorator.starbuds.beverage.Beverage;

public class HouseBlend extends Beverage {

  public HouseBlend() {
    this.description = "하우스 블렌드 커피";
  }

  public HouseBlend(int shot) {
    this();
    this.shot = shot;
  }

  public HouseBlend(Size size) {
    this();
    this.size = size;
  }

  public HouseBlend(int shot, Size size) {
    this();
    this.shot = shot;
    this.size = size;
  }

  @Override
  protected double price() {
    return switch (this.size){
      case TALL -> 2.99;
      case GRANDE -> 3.99;
      case VENTI -> 4.99;
    };
  }
}
