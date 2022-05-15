package ch03_decorator.starbuds.beverage;

public abstract class CondimentDecorator extends Beverage{

  protected Beverage beverage;

  protected CondimentDecorator() {
  }

  public String getDescription(){
    return String.format("%s, %s(%s): %d", this.beverage.getDescription(), this.description, getSize(), this.shot);
  }

  public double cost(){
    return this.beverage.cost() + (this.shot * this.price());
  }

  public void printOrder(){
    beverage.printOrder();
    super.printOrder();
  }

  public Size getSize(){
    return beverage.getSize();
  }

  @Override
  public String toString() {
    return "CondimentDecorator{" +
        "beverage=" + beverage +
        ", description='" + description + '\'' +
        ", size=" + getSize() +
        ", price=" + price() +
        ", shot=" + shot +
        ", cost=" + cost() +
        '}';
  }
}
