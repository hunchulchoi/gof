package ch03_decorator.starbuds.beverage;

import ch03_decorator.starbuds.coffee.HouseBlend;
import ch03_decorator.starbuds.condiment.Mocha;
import ch03_decorator.starbuds.condiment.SoyMilk;
import ch03_decorator.starbuds.condiment.Whip;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CondimentDecoratorTest {

  @Test
  void 더블모카_두유_휘핑크림(){

    ch03_decorator.starbuds.beverage.Beverage beverage = new HouseBlend(Beverage.Size.GRANDE);
    beverage = new Mocha(beverage, 2);
    beverage = new SoyMilk(beverage);
    beverage = new Whip(beverage);

    System.out.println(beverage.getDescription());
    System.out.println(beverage);

    beverage.printOrder();

    //assertEquals( 1.54,beverage.cost());
  }

}