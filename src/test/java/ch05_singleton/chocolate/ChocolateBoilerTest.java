package ch05_singleton.chocolate;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateBoilerTest {

  @Test
  void 보일러테스트(){

    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            ChocolateBoiler boiler = ChocolateBoiler.getInstance();

            //System.out.println(Thread.currentThread().getName() + "===========================" + boiler.hashCode());

//            //System.out.println(Thread.currentThread().getName() + " fill()");
//            boiler.fill();
//            //System.out.println(Thread.currentThread().getName() + " fill()" + boiler);
//            assertFalse(boiler.isEmpty(), Thread.currentThread().getName());
//            assertFalse(boiler.isBoiled(), Thread.currentThread().getName());
//
//            //System.out.println(Thread.currentThread().getName() + " boil()");
//            boiler.boil();
//            //System.out.println(Thread.currentThread().getName() + " boil()" + boiler);
//            assertFalse(boiler.isEmpty(), Thread.currentThread().getName());
//            assertTrue(boiler.isBoiled(), Thread.currentThread().getName());
//
//           // System.out.println(Thread.currentThread().getName() + " drain()");
//            boiler.drain();
//            //System.out.println(Thread.currentThread().getName() + " drain()" + boiler);
//            assertTrue(boiler.isEmpty(), Thread.currentThread().getName());
//            assertTrue(boiler.isBoiled(), Thread.currentThread().getName());
          }
        };

    IntStream.range(1, 100).forEach(i->{
     Thread t = new Thread(runnable, "t"+i);
     Thread t1 = new Thread(runnable, "at"+i);
     Thread t2 = new Thread(runnable, "bt"+i);
     Thread t3 = new Thread(runnable, "ct"+i);
     Thread t4 = new Thread(runnable, "dt"+i);
     Thread t5 = new Thread(runnable, "et"+i);
     t.start();
     t1.start();
     t2.start();
     t3.start();
     t4.start();
     t5.start();
    });
  }

  @Test
  void enum보일러테스트(){

    ChocolateBoilerEnum boiler = ChocolateBoilerEnum.UniqueInstance;

    System.out.println(Thread.currentThread().getName() + " fill()");
    boiler.fill();
    System.out.println(Thread.currentThread().getName() + " fill()" + boiler);
    assertFalse(boiler.isEmpty(), Thread.currentThread().getName());
    assertFalse(boiler.isBoiled(), Thread.currentThread().getName());

    System.out.println(Thread.currentThread().getName() + " boil()");
    boiler.boil();
    System.out.println(Thread.currentThread().getName() + " boil()" + boiler);
    assertFalse(boiler.isEmpty(), Thread.currentThread().getName());
    assertTrue(boiler.isBoiled(), Thread.currentThread().getName());

    System.out.println(Thread.currentThread().getName() + " drain()");
    boiler.drain();
    System.out.println(Thread.currentThread().getName() + " drain()" + boiler);
    assertTrue(boiler.isEmpty(), Thread.currentThread().getName());
    assertTrue(boiler.isBoiled(), Thread.currentThread().getName());
  }

}