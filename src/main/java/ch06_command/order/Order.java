package ch06_command.order;

import lombok.Data;

@Data
public class Order {

  private Food food;

  public Order(Food food) {
    this.food = food;
  }
}
