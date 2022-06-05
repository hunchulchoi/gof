package ch10_state.gatcha;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GatchaTest {

  @Test
  void 돈안넣고_손잡이돌림(){
    Gatcha gatcha = new Gatcha(10);
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.손잡이돌림());

    System.out.println(throwable.getMessage());
  }

  @Test
  void 돈안넣고_동전반환(){
    Gatcha gatcha = new Gatcha(10);
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전반환());

    System.out.println(throwable.getMessage());
  }

  @Test
  void 중복_동전투입(){
    Gatcha gatcha = new Gatcha(10);
    gatcha.동전투입();
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());

    assertEquals(500, gatcha.get매출());
  }

  @Test
  void 돈넣고_동전반환(){
    Gatcha gatcha = new Gatcha(10);
    gatcha.동전투입();
    assertEquals(Gatcha.STATE.동전있음, gatcha.getState());
    assertEquals(500, gatcha.get매출());
    assertEquals(0, gatcha.getCount());

    gatcha.동전반환();
    assertEquals(Gatcha.STATE.동전없음, gatcha.getState());
    assertEquals(0, gatcha.get매출());
    assertEquals(0, gatcha.getCount());
    assertEquals(10, gatcha.get알맹이());
  }

  @Test
  void 돈넣고_손잡이돌림(){
    Gatcha gatcha = new Gatcha(3);

    //뽑고
    gatcha.동전투입();
    assertEquals(Gatcha.STATE.동전있음, gatcha.getState());
    assertEquals(500, gatcha.get매출());
    assertEquals(0, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(Gatcha.STATE.동전없음, gatcha.getState());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    //반환
    gatcha.동전투입();
    assertEquals(Gatcha.STATE.동전있음, gatcha.getState());
    assertEquals(1000, gatcha.get매출());
    assertEquals(1, gatcha.getCount());

    gatcha.동전반환();
    assertEquals(Gatcha.STATE.동전없음, gatcha.getState());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    // 그냥 돌림
    Throwable exption = assertThrows(IllegalStateException.class, ()->gatcha.손잡이돌림());

    System.out.println(exption.getMessage());

    assertEquals(Gatcha.STATE.동전없음, gatcha.getState());
    assertEquals(500, gatcha.get매출());
    assertEquals(1, gatcha.getCount());
    assertEquals(2, gatcha.get알맹이());

    //뽑고
    gatcha.동전투입();
    assertEquals(Gatcha.STATE.동전있음, gatcha.getState());
    assertEquals(1000, gatcha.get매출());
    assertEquals(1, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(Gatcha.STATE.동전없음, gatcha.getState());
    assertEquals(1000, gatcha.get매출());
    assertEquals(2, gatcha.getCount());
    assertEquals(1, gatcha.get알맹이());

    //뽑고
    gatcha.동전투입();
    assertEquals(Gatcha.STATE.동전있음, gatcha.getState());
    assertEquals(1500, gatcha.get매출());
    assertEquals(2, gatcha.getCount());

    gatcha.손잡이돌림();
    assertEquals(Gatcha.STATE.알맹이매진, gatcha.getState());
    assertEquals(1500, gatcha.get매출());
    assertEquals(3, gatcha.getCount());
    assertEquals(0, gatcha.get알맹이());

    // 동전 투입
    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());
  }

  @Test
  void 매진(){
    Gatcha gatcha = new Gatcha(0);

    Throwable throwable = assertThrows(IllegalStateException.class, ()->gatcha.동전투입());

    System.out.println(throwable.getMessage());

    assertEquals(0, gatcha.get매출());
    assertEquals(0, gatcha.getCount());
  }

  @Test
  void 보너스(){
    Gatcha gatcha = new Gatcha(200);

    IntStream.range(0, 200).takeWhile(i->gatcha.get알맹이()>0)
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
}