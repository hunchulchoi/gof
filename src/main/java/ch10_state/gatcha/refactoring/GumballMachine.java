package ch10_state.gatcha.refactoring;

import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
public class GumballMachine {

  @ToString.Exclude
  private Random random = new Random(System.currentTimeMillis());

  @Getter
  private Long 매출;
  @Getter
  private int 알맹이;
  @Getter
  private int count;
  @Getter
  private int 보나스;

  @ToString.Exclude
  private final State soldState;
  @ToString.Exclude
  private final State soldOutState;
  @ToString.Exclude
  private final State noQuarterState;
  @ToString.Exclude
  private final State hasQuarterState;
  @ToString.Exclude
  private final State winningState;

  @Getter
  private State state;

  public GumballMachine(int 알맹이) {
    this.알맹이 = 알맹이;
    this.매출 = 0L;
    this.count = 0;
    this.보나스 = 0;

    soldState = new SoldState();
    soldOutState = new SoldOutState();
    noQuarterState = new NoQuarterState();
    hasQuarterState = new HasQuarterState();
    winningState = new WinningState();

    if(알맹이==0) state = soldOutState;
    else state = noQuarterState;
  }

  public State setState(State.STATE state){
    switch (state){
      case 동전있음 -> this.state = hasQuarterState;
      case 동전없음 -> this.state = noQuarterState;
      case 알맹이매진 -> this.state = soldOutState;
      case 알맹이판매 -> this.state = soldState;
      case 보너스 -> this.state = winningState;
    }

    return this.state;
  }

  public void 동전투입(){
    try{
      state.동전투입();
      this.매출+=500;
      setState(State.STATE.동전있음);
    }catch (IllegalStateException e){
      System.err.println(e.getMessage());
    }
  }

  public void 동전반환(){

    try {
      state.동전반환();
      this.매출-=500;
      setState(State.STATE.동전없음);
    } catch (IllegalStateException e) {
      System.err.println(e.getMessage());
    }
  }

  public void 손잡이돌림(){

    try {
      state.손잡이돌림();
      System.out.println("알맹이:" + 알맹이);
      setState(State.STATE.알맹이판매);
      알맹이_내보냄();
      this.count +=1;

      if(this.알맹이>0 && random.nextInt(10)==0){
        setState(State.STATE.보너스);
        state.손잡이돌림();
        this.보나스 +=1;
        알맹이_내보냄();
      }
    } catch (IllegalStateException e) {
      System.err.println(e.getMessage());
    }
  }

  public void 리필(int size){

    try {
      state.리필();
      this.알맹이 = size;
      setState(State.STATE.동전없음);
    } catch (IllegalStateException e) {
      System.err.println(e.getMessage());
    }
  }

  protected void 알맹이_내보냄(){
    this.알맹이-=1;
    if(this.알맹이==0) setState(State.STATE.알맹이매진);
    else setState(State.STATE.동전없음);
  }

}
