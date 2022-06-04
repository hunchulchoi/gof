package ch08_template_method.cafe.cafe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class CaffeineBeverageWithHookTest {

  @Test
  void prepareRecipe() {

    CaffeineBeverageWithHook coffeeWithHook = new CoffeeWithHook();

    System.setIn(new ByteArrayInputStream("Y".getBytes()));

    coffeeWithHook.prepareRecipe();

    System.setIn(new ByteArrayInputStream("N".getBytes()));

    coffeeWithHook.prepareRecipe();

  }
}