package ch08_template_method.cafe.cafe;

public abstract class Caffeinbeverage {
  /**
   * template method
   * 서브 클래스가 각 단계를 변경 할 수 없도록 final로 선언
   */
  public final void prepareRecipe(){
    boilWater();
    brew();
    pourInCup();
    addCondiments();
    complete();
  }
  void boilWater(){
    System.out.println("물 끓이는 중..보골보골");
  }
  void pourInCup(){
    System.out.println("쪼르르 컵에 따릅니다.");
  }
  abstract void brew();
  abstract void addCondiments();
  abstract void complete();

}

