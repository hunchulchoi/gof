package ch08_template_method.cafe.cafe;

import java.util.Scanner;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

  private boolean customerWants;

  @Override
  void brew() {
    System.out.println("에스프레소 뽑아요 칙칙");
  }

  @Override
  void addCondiments() {
    if(customerWants) System.out.println("스팀 밀크와 시럽 추가 뿜뿜");
  }

  @Override
  void complete() {
    System.out.println("까페라떼 완성");
  }

  @Override
  void hook(){
    System.out.println("커피에 우유와 시럽을 넣을까요?");

    try(Scanner scanner = new Scanner(System.in)){

      if("Y".equals(scanner.next())){
        this.customerWants = true;
        System.out.println("네 우유와 시럽을 넣을께요");
      }else{
        this.customerWants = false;
        System.out.println("네 우유와 시럽을 넣지 않을 께요");
      }
    }

  }
}
