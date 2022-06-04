package ch08_template_method.cafe.cafe;

public class BlackTea extends Caffeinbeverage {
  @Override
  void brew() {
    System.out.println("뜨거운 물에 찻잎을 우리고 있습니다.");
  }

  @Override
  void addCondiments() {
    System.out.println("레몬을 섞어 보겠스빈다.");
  }

  @Override
  void complete() {
    System.out.println("홍차 대령이요");
  }
}
