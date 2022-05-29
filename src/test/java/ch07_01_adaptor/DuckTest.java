package ch07_01_adaptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {

  @Test
  void duckTest(){

    System.out.println("오리가 말하길");
    Duck mallarDuck = new MallarDuck();
    mallarDuck.quack();
    mallarDuck.fly();

  }

  @Test
  void turkeyAdaptorTest(){
    System.out.println("칠면조 입니다.");
    Duck turkey = new TurkeyAdaptor(new WildTurkey());
    turkey.quack();
    turkey.fly();
  }
}