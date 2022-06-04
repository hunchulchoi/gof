package ch08_template_method.cafe.cafe;

public class Coffee extends Caffeinbeverage{

  @Override
  void brew() {
    System.out.println("에스프레소 뽑아요 칙칙");
  }

  @Override
  void addCondiments() {
    System.out.println("스팀 밀크와 시럽 추가 뿜뿜");
  }

  @Override
  void complete() {
    System.out.println("까페라떼 완성");
  }
}
