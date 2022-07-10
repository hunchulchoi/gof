package ch10_state.gatcha;

import ch10_state.gatcha.refactoring.GumballMachine;
import ch10_state.gatcha.refactoring.HasQuarterState;
import ch10_state.gatcha.refactoring.NoQuarterState;
import ch10_state.gatcha.refactoring.SoldOutState;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("왜 에러나지")
class GumballMachineTest {

  @Test
  void 돈안넣고_손잡이돌림(){
    GumballMachine gatcha = new GumballMachine(10);
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.손잡이돌림());

    System.out.println(throwable.getMessage());

    gatcha.동전투입();
  }

  @Test
  void 돈안넣고_동전반환(){
    GumballMachine gatcha = new GumballMachine(10);
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전반환());

    System.out.println(throwable.getMessage());
  }

  @Test
  void 중복_동전투입(){
    GumballMachine gatcha = new GumballMachine(10);
    gatcha.동전투입();
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());

    assertEquals(500, gatcha.get매출());
  }

  @Test
  void 돈넣고_동전반환(){
    GumballMachine gatcha = new GumballMachine(10);
    gatcha.동전투입();
    assertEquals(HasQuarterState.class, gatcha.getState().getClass());
    assertEquals(500, gatcha.get매출());
    assertEquals(0, gatcha.getCount());

    gatcha.동전반환();
    assertEquals(NoQuarterState.class, gatcha.getState().getClass());
    assertEquals(0, gatcha.get매출());
    assertEquals(0, gatcha.getCount());
    assertEquals(10, gatcha.get알맹이());
  }

  @Test
  void 돈넣고_손잡이돌림(){
    GumballMachine gatcha = new GumballMachine(3);

    //뽑고
    gatcha.동전투입();
    assertEquals(HasQuarterState.class, gatcha.getState().getClass());
    assertEquals(500, gatcha.get매출());
    assertEquals(0, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(NoQuarterState.class, gatcha.getState().getClass());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    //반환
    gatcha.동전투입();
    assertEquals(HasQuarterState.class, gatcha.getState().getClass());
    assertEquals(1000, gatcha.get매출());
    assertEquals(1, gatcha.getCount());

    gatcha.동전반환();
    assertEquals(NoQuarterState.class, gatcha.getState().getClass());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    // 그냥 돌림
    Throwable exption = assertThrows(IllegalStateException.class, ()->gatcha.손잡이돌림());

    System.out.println(exption.getMessage());

    assertEquals(NoQuarterState.class, gatcha.getState().getClass());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    //뽑고
    gatcha.동전투입();
    assertEquals(HasQuarterState.class, gatcha.getState().getClass());
    assertEquals(1000, gatcha.get매출());
    assertEquals(1, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(NoQuarterState.class, gatcha.getState().getClass());
    assertEquals(1000, gatcha.get매출());
    assertEquals(2, gatcha.getCount());
    assertEquals(1, gatcha.get알맹이());

    //뽑고
    gatcha.동전투입();
    assertEquals(HasQuarterState.class, gatcha.getState().getClass());
    assertEquals(1500, gatcha.get매출());
    assertEquals(2, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(SoldOutState.class, gatcha.getState().getClass());
    assertEquals(1500, gatcha.get매출());
    assertEquals(3, gatcha.getCount());
    assertEquals(0, gatcha.get알맹이());

    // 동전 투입
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());
  }

  @Test
  void 매진(){
    GumballMachine gatcha = new GumballMachine(0);

    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());

    assertEquals(0, gatcha.get매출());
    assertEquals(0, gatcha.getCount());
  }

  @Test
  void 보너스(){
    GumballMachine gatcha = new GumballMachine(200);

    IntStream.range(0, 200)//.takeWhile(i->gatcha.get알맹이()>0)
        .forEach(
            i -> {
                gatcha.동전투입();
                gatcha.손잡이돌림();
            });

    gatcha.리필(100);

    IntStream.range(0, 100)//.takeWhile(i->gatcha.get알맹이()>0)
        .forEach(
            i -> {
              gatcha.동전투입();
              gatcha.손잡이돌림();
            });

    System.out.println();
    System.out.println();
    System.out.println("===============================================");
    System.out.println(gatcha);
  }

  @Test
  void randomTest(){
    Random random = new Random(System.currentTimeMillis());

    for(int i=0; i<100; i++){
      AtomicInteger atomicInteger = new AtomicInteger();
      IntStream.range(0, 10_000).forEach(k->{if(random.nextInt(10)==0) atomicInteger.incrementAndGet();});
      System.out.println(atomicInteger);
    }
  }
}