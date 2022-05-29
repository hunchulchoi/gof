package ch06_command.order;

public class Chief {

  private Food makeBuger(){
    Food food = Food.Bugger;
    System.out.println(food + " 나왔습니다.");
    return food;
  }

  private Food make김치째개(){
    Food food = Food.Bugger;
    System.out.println(food + " 나왔습니다.");
    return food;
  }

  Food orderUp(Order order){
    return switch (order.getFood()){
      case 김치찌개 -> make김치째개();
      case Bugger -> makeBuger();
      default -> throw new UnsupportedOperationException("없어->" + order);
    };
  }
}
