package ch03_decorator.starbuds.beverage;

import lombok.Getter;

public abstract class Beverage {

  protected enum Size{TALL, GRANDE, VENTI};

  protected int shot =1;

  @Getter
  protected Size size = Size.TALL;

  public Beverage() {
  }

  public Beverage(int shot) {
    this.shot = shot;
  }

  public Beverage(Size size) {
    this.size = size;
  }

  public Beverage(int shot, Size size) {
    this.shot = shot;
    this.size = size;
  }

  protected String description = "제목없음";

  protected abstract double price();

  public double cost(){
    return this.price() * this.shot;
  }

  public String getDescription() {
    return String.format("%s(%s):%d", description, size, shot);
  }

  public void printOrder(){
    System.out.println(this.description + ": " + this.price() + "* " + this.shot + "= " + (this.price() * this.shot));
  }

  @Override
  public String toString() {
    return "Beverage{" +
        "description='" + description +
        ", size=" + size +
        ", price=" + price() +
        ", shot=" + shot +
        ", cost=" + cost() + '\'' +
        '}';
  }
}
