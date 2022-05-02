package ch01_strategy;

import ch01_strategy.behavior.FlyRocketPowered;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {

  @Test
  void mallardDuckTest(){

    Duck mallardDuck = new MallardDuck();

    Assertions.assertNotNull(mallardDuck.swim());
    Assertions.assertNotNull(mallardDuck.perfumeQuack());
    Assertions.assertNotNull(mallardDuck.display());
    Assertions.assertNotNull(mallardDuck.perfumeFly());
  }

  @Test
  void redHeadDuckTest(){
    Duck redHeadDuck = new RedHeadDuck();

    Assertions.assertNotNull(redHeadDuck.swim());
    Assertions.assertNotNull(redHeadDuck.perfumeQuack());
    Assertions.assertNotNull(redHeadDuck.display());
    Assertions.assertNotNull(redHeadDuck.perfumeFly());
  }

  @Test
  void rubberDuckTest(){
    Duck rubberDuck = new RubberDuck();

    Assertions.assertNotNull(rubberDuck.swim());
    Assertions.assertEquals("Beep Beep",rubberDuck.perfumeQuack());
    Assertions.assertNotNull(rubberDuck.display());
    Assertions.assertNull(rubberDuck.perfumeFly());
  }

  @Test
  void decoyDuckTest(){
    Duck decoyDuck = new DecoyDuck();

    Assertions.assertNotNull(decoyDuck.swim());
    Assertions.assertNull(decoyDuck.perfumeQuack());
    Assertions.assertNotNull(decoyDuck.display());
    Assertions.assertNull(decoyDuck.perfumeFly());
  }

  @Test
  void modelDuckTest(){
    Duck modelDuck = new ModelDuck();

    Assertions.assertNotNull(modelDuck.swim());
    Assertions.assertNotNull(modelDuck.perfumeQuack());
    Assertions.assertNotNull(modelDuck.display());
    assertEquals("flying...." ,modelDuck.perfumeFly());

    modelDuck.setFlyBehavior(new FlyRocketPowered());

    assertEquals("Shhhhhhhhhhhhhhhhhhhhhhh * 100 faster", modelDuck.perfumeFly());
  }

}