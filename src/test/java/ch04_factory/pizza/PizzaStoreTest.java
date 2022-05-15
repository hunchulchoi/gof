package ch04_factory.pizza;

import ch04_factory.pizza.factory.NyPizzaFactory;
import ch04_factory.pizza.factory.SimplePizzaFactory;
import ch04_factory.pizza.pizza.*;
import ch04_factory.pizza.store.AbPizzaStore;
import ch04_factory.pizza.store.ChicagoPizzaStore;
import ch04_factory.pizza.store.NyPizzaStore;
import ch04_factory.pizza.store.PizzaStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {

  @Test
  void orderPizza() {

    PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());

    Pizza pizza = pizzaStore.orderPizza("cheese");

    assertEquals(CheesePizza.class.getName(), pizza.getClass().getName());
  }

  @Test
  void orderPizzaNy() {

    PizzaStore pizzaStore = new PizzaStore(new NyPizzaFactory());

    Pizza pizza = pizzaStore.orderPizza("cheese");

    assertEquals(NyCheesePizza.class.getName(), pizza.getClass().getName());
  }

  @Test
  void orderPizzaNySuper() {

    PizzaStore pizzaStore = new PizzaStore(new NyPizzaFactory());

    Pizza pizza = pizzaStore.orderPizza("peperoni");

    assertEquals(PepperoniPizza.class.getName(), pizza.getClass().getName());
  }

  @Test
  void orderPizzaThrow() {

    PizzaStore pizzaStore = new PizzaStore(new NyPizzaFactory());

    assertThrows(UnsupportedOperationException.class, ()->pizzaStore.orderPizza("kimchi"));
  }

  @Test
  void nyStoreTest(){

    AbPizzaStore pizzaStore = new NyPizzaStore();
    Pizza cheese = pizzaStore.orderPizza("pepperoni");

    assertEquals(NyPepperoniPizza.class.getName(), cheese.getClass().getName());
  }

  @Test
  void 주문테스트(){
    AbPizzaStore nyStore = new NyPizzaStore();
    AbPizzaStore chStore = new ChicagoPizzaStore();

    Pizza forEdan = nyStore.orderPizza("pepperoni");
    Pizza forMun = chStore.orderPizza("cheese");

    assertEquals(NyPepperoniPizza.class.getName(), forEdan.getClass().getName());
    assertEquals(ChicagoCheesePizza.class.getName(), forMun.getClass().getName());
  }

  @Test
  void di테스트(){

    ch04_factory.pizza.di.store.PizzaStore store = new ch04_factory.pizza.di.store.NyPizzaStore();

    ch04_factory.pizza.di.pizza.Pizza pizza = store.orderPizza("cheese");

    System.out.println(pizza);

    assertEquals("뉴욕 스타일 치즈 피자", pizza.getName());
  }

}