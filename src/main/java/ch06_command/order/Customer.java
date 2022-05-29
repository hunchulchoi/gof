package ch06_command.order;

public class Customer {

  private Server server = new Server();

  Order createOrder(Food food){

    Order order = new Order(food);

    System.out.println(order + " 주세요");

    return order;
  }

  public Food order(Food food){
    Order order = createOrder(food);

    Food food1 = server.takeOrder(order);

    System.out.println(food + " 잘먹겠습니다.");

    return food;
  }
}
