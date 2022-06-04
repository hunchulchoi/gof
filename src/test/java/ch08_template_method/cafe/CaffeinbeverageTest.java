package ch08_template_method.cafe;

import ch08_template_method.cafe.cafe.BlackTea;
import ch08_template_method.cafe.cafe.Caffeinbeverage;
import ch08_template_method.cafe.cafe.Coffee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaffeinbeverageTest {

  @Test
  void 커피테스트(){
    Caffeinbeverage coffee = new Coffee();
    coffee.prepareRecipe();
  }

  @Test
  void 홍차테스트(){
    Caffeinbeverage blackTea = new BlackTea();
    blackTea.prepareRecipe();
  }

}