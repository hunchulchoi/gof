package ch06_command.order;

public class Server {

  private Chief chief = new Chief();

  public Food takeOrder(Order order){
    System.out.println(order + " 주문이요");

    Food food = chief.orderUp(order);

    System.out.println(food + " 맛있게 드세요");

    return food;
  }

}
