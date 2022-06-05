package ch10_state.gatcha;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static ch10_state.gatcha.Gatcha.STATE.*;

@ToString
public class Gatcha {

  @Getter
  private Long 매출;
  @Getter
  private int 알맹이;
  @Getter
  private int count;
  @Getter
  private int 보나스;

  private ArrayList<Boolean> bonus = new ArrayList<>(10);

  public Gatcha(int 알맹이) {
    this.알맹이 = 알맹이;
    this.매출 = 0L;
    this.count = 0;
    setState(동전없음);
  }

  public enum STATE{
    동전있음, 동전없음, 알맹이판매, 알맹이매진
  }

  @Getter
  private STATE state;

  public void 동전투입(){
    if(this.state==알맹이매진) throw new IllegalStateException("현재 매진 입니다.");
    if(this.알맹이==0) setState(알맹이매진);
    if(this.state!=동전없음) throw new IllegalStateException("지금은 동전을 넣을 수 없습니다. 현재상태:" + state);
    this.매출 += 500;
    setState(동전있음);
  }

  public void 동전반환(){
    if(this.state!=동전있음) throw new IllegalStateException("반환할 동전이 없습니다. 현재상태:" + state);
    //System.out.println("동전이 반환됩니다.");
    this.매출 -= 500;
    setState(동전없음);
  }

  public void 손잡이돌림(){
    if(this.state!=동전있음) throw new IllegalStateException("돈을 넣으세요 현재상태:" + state);
    //System.out.println("띠리리리리리~~~");

    if(알맹이==0){
      매출-=500;
      setState(알맹이매진);
      return;
    }

    알맹이_내보냄();
    if(알맹이>=1) 보너스();
  }

  private void 알맹이_내보냄(){
    this.count += 1;
    this.알맹이 -=1;
    setState(알맹이판매);
    if(this.알맹이==0) setState(알맹이매진);
    else setState(동전없음);
  }

  private void 보너스(){
    if(bonus.isEmpty()) bonus = new ArrayList<>(Arrays.asList(false, false, false, false, false, false, false, false, true));

    Random random = new Random();

    int index = random.nextInt(bonus.size());
    boolean b = bonus.get(index);

    if(b){
      System.out.println("=========================와우 보너스 당첨 되었습니다.================================");
      보나스+=1;
      알맹이_내보냄();
    }

    bonus.remove(index);
    System.out.println(bonus.size() + ":" + bonus);
  }

  private void setState(STATE state){
    this.state = state;

    switch (state){
      case 동전없음 -> System.out.println("Insert Coin...");
      case 동전있음 -> System.out.println("손잡이를 돌리세요");
      case 알맹이판매 -> System.out.println("알맹이를 확인해 주세요");
      case 알맹이매진 -> System.out.println("매진 입니다.");
    }

    System.out.println(this);
  }

}
